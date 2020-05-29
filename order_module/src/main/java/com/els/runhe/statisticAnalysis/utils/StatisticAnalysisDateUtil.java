package com.els.runhe.statisticAnalysis.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

public class StatisticAnalysisDateUtil {
	/**
	 * 获取当前月份的第一天到最后一天
	 * @return
	 */
	public static List<String> getDayListOfMonth() {
		List<String> list = new ArrayList<String>();
	    Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
	    int year = aCalendar.get(Calendar.YEAR);//年份
	    int month = aCalendar.get(Calendar.MONTH)+1;//月份
	    int day = aCalendar.getActualMaximum(Calendar.DATE);
	    for (int i = 1; i <= day; i++) {
	    	String aDate = "";
	    	if(i < 10 ){
	    		if (month < 10) {
	    			aDate = String.valueOf(year)+"-0"+month+"-0"+i;
	    		}else{
	    			aDate = String.valueOf(year)+"-"+month+"-0"+i;
	    		}
	    	}else {
	    		if (month < 10) {
	    			aDate = String.valueOf(year)+"-0"+month+"-"+i;
	    		}else{
	    			aDate = String.valueOf(year)+"-"+month+"-"+i;
	    		}
	    	}
	        list.add(aDate);
	    }
	    return list;
	}
	
	public static String getLastMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Calendar calendar = Calendar.getInstance();  
  
        //月份减一  
        calendar.add(Calendar.MONTH, -1);
        return sdf.format(calendar.getTime());
	}
	
	public static String getMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Calendar calendar = Calendar.getInstance();  
  
        return sdf.format(calendar.getTime());
	}
	
	public static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
	}
	
	/**
     * 获取时间段
     * @param beginTime
     * @param endTime
     * @param dateFormat
     * @return
     */
    public static List<String> getDates(String beginTime,String endTime,String dateFormat){
        try{
            List<String> list = new ArrayList<String>();
            DateFormat df = null;
            if(!StringUtils.isEmpty(dateFormat)){
                df = new SimpleDateFormat(dateFormat);
            }else{
                df = new SimpleDateFormat("yyyy-MM-dd");
            }
            Date begin = df.parse(beginTime);
            Date end = df.parse(endTime);
            // 如果开始日期大于结束日期，则返回空数组
            if (begin.after(end)) {
				return list;
			}
            // 如果开始日期和结束日期相同，则只返回一天
            if (begin.equals(end)) {
            	list.add(beginTime);
            	return list;
            }
            
            Calendar cal0 = new GregorianCalendar();
            cal0.setTime(begin);
            list.add(beginTime);
//            int i = 0;
            while(true){
                cal0.add(Calendar.DATE, 1);
                String date = df.format(cal0.getTime());
                list.add(date);
                if(date.equalsIgnoreCase(endTime)){
                    break ;
                }
//                i++;
//                if(i>365){
//                    //最多计算100天
//                    break ;
//                }
            }
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public static void main(String[] args) {
    	List<String> dateList = getDates("2010-01-29","2018-01-29","yyyy-MM-dd");
    	System.out.println(dateList);
	}
	
}
