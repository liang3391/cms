package com.demo;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qianqian.cms.model.MapAdLocationEntity;
import com.qianqian.cms.service.IMapAdTaskService;

public class Test {

	public static void main(String[] args){
		
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"/spring/applicationContext.xml");
			IMapAdTaskService service = (IMapAdTaskService) ctx
					.getBean("mapAdTaskService");
			MapAdLocationEntity mapAd = new MapAdLocationEntity();
			mapAd.setId(101L);
			mapAd.setLocationId(101L);
			//mapAd.setStartTime(DateUtil.addMilliseconds(new Date(), 1));
			mapAd.setStartTime(DateUtils.addSeconds(new Date(), 10));
			mapAd.setEndTime(DateUtils.addSeconds(new Date(), 20));
			mapAd.setLocationType(5);
			
				try {
					service.createMapAdTask(mapAd);
				} catch (Exception e) {
					System.out.println(e.toString()+"-----------------------");
					e.printStackTrace();
				}
			
	 	


	}

}
