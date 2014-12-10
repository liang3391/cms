package com.qianqian.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.framelib.utils.ConfigUtils;

/**
 * 系统常量类 Title:Constants Description:
 * 
 * @Create_by:Zhangy Yan
 * @Create_date:2014-04-04
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
public class Constants {

	// redis-key属性文件
	private final static Properties REDIS_KEY_PROPS = ConfigUtils
			.getPropertiesFile("conf/redis-key.properties");

	// redis list test key name
	public static final String REIDS_LIST_TEST_KEY = (String) REDIS_KEY_PROPS
			.get("reids.list.test.key");
	/**
	 * 日期格式
	 */
	public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 可以上传的图片类型列表
	 */
	public static final List<String> IMAGE_TYPES = new ArrayList<String>();
	static {
		IMAGE_TYPES.add("jpg");
		IMAGE_TYPES.add("jpeg");
		IMAGE_TYPES.add("bmp");
		IMAGE_TYPES.add("gif");
	}

}
