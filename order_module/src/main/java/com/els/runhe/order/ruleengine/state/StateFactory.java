package com.els.runhe.order.ruleengine.state;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.collections.CollectionUtils;

import com.els.runhe.order.entity.Order;

/**
 * 状态工厂类
 * @author hzy
 *
 */
public abstract class StateFactory {
	
	private static Set<Class<? extends AbstractOrderState>> stateClasses = null;

	public static List<AbstractOrderState> buildStates(Order order)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException, IOException {
		
		if (stateClasses == null) {
			stateClasses = getAllStateClasses();
		}

		if (CollectionUtils.isEmpty(stateClasses)) {
			return null;
		}

		// 3、遍历所有的实现类，并每个都new 一个对象
		List<AbstractOrderState> stateList = new ArrayList<>();
		for (Class<? extends AbstractOrderState> clazz : stateClasses) {
			Constructor<? extends AbstractOrderState> constructor = clazz.getConstructor(Order.class);
			AbstractOrderState instance = constructor.newInstance(order);
			stateList.add(instance);
		}

		return stateList;
	}
	
	public static Set<Class<? extends AbstractOrderState>> getAllStateClasses() throws ClassNotFoundException, IOException{
		Set<Class<? extends AbstractOrderState>> stateClasses = new HashSet<>();

		// 1、查询包内的所有类
		Set<Class<?>> allClassInPack = getClasses("com.els.runhe", true);
		Iterator<Class<?>> classesIterator = allClassInPack.iterator();

		// 2、遍历每个类，把继承了 AbstractOrderState 的类找出来
		while (classesIterator.hasNext()) {
			Class<?> clazz = classesIterator.next();

			if (!AbstractOrderState.class.equals(clazz.getSuperclass())) {
				continue;
			}

			stateClasses.add((Class<? extends AbstractOrderState>) clazz);
		}
		return stateClasses;
	}

	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @param recursive
	 *            是否循环迭代
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Set<Class<?>> getClasses(String pack, boolean recursive) throws ClassNotFoundException, IOException {

		// 第一个class类的集合
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();

		// 获取包的名字 并进行替换
		String packageDirName = pack.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

		// 循环迭代下去
		while (dirs.hasMoreElements()) {
			URL url = dirs.nextElement();
			String protocol = url.getProtocol();

			// 如果是以文件的形式保存在服务器上
			if ("file".equals(protocol)) {
				// 获取包的物理路径
				String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
				// 以文件的方式扫描整个包下的文件 并添加到集合中
				findAndAddClassesInPackageByFile(pack, filePath, recursive, classes);

			} else if ("jar".equals(protocol)) {
				findAndAddClassInPackageByJar(url, packageDirName, pack, recursive, classes);
			}
		}

		return classes;
	}

	private static void findAndAddClassInPackageByJar(URL url, String packageDirName, String packageName,
			boolean recursive, Set<Class<?>> classes) throws ClassNotFoundException, IOException {

		JarFile jar;
		// 获取jar
		jar = ((JarURLConnection) url.openConnection()).getJarFile();
		// 从此jar包 得到一个枚举类
		Enumeration<JarEntry> entries = jar.entries();
		// 同样的进行循环迭代
		while (entries.hasMoreElements()) {
			// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
			JarEntry entry = entries.nextElement();
			String name = entry.getName();
			// 如果是以/开头的
			if (name.charAt(0) == '/') {
				// 获取后面的字符串
				name = name.substring(1);
			}
			// 如果前半部分和定义的包名相同
			if (name.startsWith(packageDirName)) {
				int idx = name.lastIndexOf('/');
				// 如果以"/"结尾 是一个包
				if (idx != -1) {
					// 获取包名 把"/"替换成"."
					packageName = name.substring(0, idx).replace('/', '.');
				}
				// 如果可以迭代下去 并且是一个包
				if ((idx != -1) || recursive) {
					// 如果是一个.class文件 而且不是目录
					if (name.endsWith(".class") && !entry.isDirectory()) {
						// 去掉后面的".class" 获取真正的类名
						String className = name.substring(packageName.length() + 1, name.length() - 6);
						// 添加到classes
						classes.add(Class.forName(packageName + '.' + className));
					}
				}
			}
		}

	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 * @throws ClassNotFoundException 
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive,
			Set<Class<?>> classes) throws ClassNotFoundException {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("用户定义包名 " + packageName + " 下没有任何文件");
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().replaceAll("\\.class$", "");
				// 添加到集合中去
				// classes.add(Class.forName(packageName + '.' +
				// className));
				// 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
				classes.add(Class.forName(packageName + '.' + className));
			}
		}
	}

}
