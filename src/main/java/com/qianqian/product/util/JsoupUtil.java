package com.qianqian.product.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * Title:JsoupUtil
 * @Description:
 * @Create_by:yinsy
 * @Create_date:2014-6-6
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class JsoupUtil {
	/**
	 * 过滤html信息，剩下白名单的标签
	 * @Create_by:yinsy
	 * @Create_date:2014-6-6
	 * @param unsafe
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	public static String getFilterHtml(String unsafe){
		//basicWithImages 除basic外增加图片标签
		String safe = Jsoup.clean(unsafe, Whitelist.basicWithImages());
		return safe;
	}
}
