package com.qianqian.common.service.impl;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;

import com.qianqian.common.mapper.AdLocationMapper;
import com.qianqian.common.model.AdLocationExample;
import com.qianqian.common.service.ILocationService;
/**
 * 位置location的控制器
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.LocationService.java
 * @ClassName	: LocationService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年6月6日 上午10:53:37
 */
@Service
public class LocationService implements ILocationService {
	@Resource
	private AdLocationMapper adLocationMapper;
	/**
	 * 根据位置类型，页面类型，类目id来获取有多少个位置
	 */
	public int getLocationCount(int locationType,int pageType,long categoryId) {
		
		AdLocationExample example=new AdLocationExample();
		if(categoryId==0){
			example.createCriteria().andLocationTypeEqualTo(locationType).andPageTypeEqualTo(pageType);
		}
		else{
			example.createCriteria().andLocationTypeEqualTo(locationType).andPageTypeEqualTo(pageType).andCategoryEqualTo(categoryId);
		}
		return adLocationMapper.countByExample(example);
		
	}

}
