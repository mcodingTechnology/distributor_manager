package com.els.runhe.market.service.train.impl;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.company.entity.UserArea;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.user.User;
import com.els.base.core.entity.user.UserExample;
import com.els.base.core.service.user.UserService;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.market.dao.train.MarketTrainApplyMapper;
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.entity.train.MarketTrainApplyExample;
import com.els.runhe.market.service.train.MarketTrainApplyService;
import com.els.runhe.region.dao.RegionMapper;
import com.els.runhe.region.entity.Region;
import com.els.runhe.region.entity.RegionExample;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultMarketTrainApplyService")
public class MarketTrainApplyServiceImpl implements MarketTrainApplyService {
    @Resource
    protected MarketTrainApplyMapper marketTrainApplyMapper;
    
    @Resource
    protected UserService userService;
    
    @Resource
    protected RegionMapper regionMapper;
    
    private static final String TRAIN_CODE_GENERATE = "MARKET_TRAIN_CODE";
    protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);

    @CacheEvict(value={"marketTrainApply"}, allEntries=true)
    @Override
    public void addObj(MarketTrainApply t) {
    	//培训申请编号自动生成 例如：MT2017111300000001
    	String code =generateCodeService.getNextCode(TRAIN_CODE_GENERATE);
    	t.setTrainApplyId(code);
        this.marketTrainApplyMapper.insertSelective(t);
        //启动审批
        //SpringContextHolder.getApplicationContext().publishEvent(new MarketTrainApplyEvent(t));
    }

    @CacheEvict(value={"marketTrainApply"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.marketTrainApplyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"marketTrainApply"}, allEntries=true)
    @Override
    public void modifyObj(MarketTrainApply t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.marketTrainApplyMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="marketTrainApply", keyGenerator="redisKeyGenerator")
    @Override
    public MarketTrainApply queryObjById(Integer id) {
        return this.marketTrainApplyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="marketTrainApply", keyGenerator="redisKeyGenerator")
    @Override
    public List<MarketTrainApply> queryAllObjByExample(MarketTrainApplyExample example) {
        return this.marketTrainApplyMapper.selectByExample(example);
    }

    @Cacheable(value="marketTrainApply", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<MarketTrainApply> queryObjByPage(MarketTrainApplyExample example) {
        PageView<MarketTrainApply> pageView = example.getPageView();
        pageView.setQueryResult(this.marketTrainApplyMapper.selectByExampleByPage(example));
        return pageView;
    }

    @CacheEvict(value={"marketTrainApply"}, allEntries=true)
	@Override
	public void modifyObjByExample(MarketTrainApply record, MarketTrainApplyExample example) {
		this.marketTrainApplyMapper.updateByExampleSelective(record, example);
	}

	@Cacheable(value="marketTrainApply", keyGenerator="redisKeyGenerator")
	@Override
	public MarketTrainApply queryByTrainApplyId(String trainApplyId) {
		MarketTrainApply marketTrainApply = this.marketTrainApplyMapper.selectByTrainApplyId(trainApplyId);
		return marketTrainApply;
	}
	
	@Override
	public List<String> returnAreaList() {
    	List<Integer> ids = new ArrayList<Integer>();
    	List<String> userIds = new ArrayList<String>();
    	List<Integer> bigAreaIds = new ArrayList<Integer>();
    	String userId = SpringSecurityUtils.getLoginUserId();
    	if(StringUtils.isNotEmpty(userId)){
    		User user = this.userService.queryObjById(userId);
    		if(StringUtils.isNotEmpty(user.getUserArea())){
    			List<UserArea> userAreas = new ArrayList<UserArea>();
    			JSONArray jsonArray = JSONArray.fromObject(user.getUserArea());
    			userAreas = (List<UserArea>) jsonArray.toCollection(jsonArray, UserArea.class);
    			for(UserArea values : userAreas){
    				if ("1".equals(values.getId())) {
    					ids.add(370000);
    					ids.add(320000);
    					ids.add(340000);
    					ids.add(360000);
    					ids.add(310000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("2".equals(values.getId())) {
    					ids.add(440000);
    					ids.add(450000);
    					ids.add(460000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("3".equals(values.getId())) {
    					ids.add(420000);
    					ids.add(430000);
    					ids.add(410000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("4".equals(values.getId())) {
    					ids.add(110000);
    					ids.add(120000);
    					ids.add(130000);
    					ids.add(140000);
    					ids.add(150000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("5".equals(values.getId())) {
    					ids.add(640000);
    					ids.add(650000);
    					ids.add(630000);
    					ids.add(610000);
    					ids.add(620000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("6".equals(values.getId())) {
    					ids.add(510000);
    					ids.add(530000);
    					ids.add(520000);
    					ids.add(540000);
    					ids.add(500000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("7".equals(values.getId())) {
    					ids.add(210000);
    					ids.add(220000);
    					ids.add(230000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("9".equals(values.getId())) {
    					ids.add(330000);
    					ids.add(350000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else{
    					ids.add(Integer.parseInt(values.getId()));
    				}
    			}
    			List<Integer> regionIds = new ArrayList<Integer>();
    			regionIds.addAll(ids);
    			boolean flag = true;
    			while (flag) {
    				RegionExample example = new RegionExample();
    				RegionExample.Criteria criteria = example.createCriteria();
    				criteria.andParentIdIn(regionIds);
    				List<Region> regionList = regionMapper.selectByExample(example);
    				regionIds = new ArrayList<Integer>();
    				int size = ids.size();
    				if (CollectionUtils.isNotEmpty(regionList)){
    					for (Region region : regionList) {
    						if (!ids.contains(region.getId())) {
    							ids.add(region.getId());
    							regionIds.add(region.getId());
    						}
    					}
    					if (size == ids.size()) {
    						flag = false;
    					}
    				}else {
    					flag = false;
    				}
    			}
    			if (CollectionUtils.isNotEmpty(bigAreaIds)){
    				for (Integer id : bigAreaIds) {
						ids.add(id);
					}
    			}
    			String str = new String();
                if (CollectionUtils.isNotEmpty(ids)){
                	for (Integer id : ids) {
                		str += '"'+"id"+'"' + ":" +'"' +id+ '"'+"|";
                	}
                	if(str.length()>1){
                		str = str.substring(0, str.length()-1);
                    }
                	UserExample userExample = new UserExample();
                	UserExample.Criteria criteria = userExample.createCriteria();
                	criteria.andUserAreaREGEXP(str);
                	List<User> userList = this.userService.queryAllObjByExample(userExample);
                	if (CollectionUtils.isNotEmpty(userList)){
                		for (User model : userList) {
                			userIds.add(model.getId());
                		}
                	}
                }
    		}
    	}
    	return userIds;
    }
}