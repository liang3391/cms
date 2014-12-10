package com.qianqian.product.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title:ResponseUtil
 * Description:HttpServletResponse工具类
 * @Create_by:yinsy
 * @Create_date:2013-08-02
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 */
public final class ResponseUtil {
	public static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);

	/**
	 * 发送文本。使用UTF-8编码。
	 */
	public static void renderText(HttpServletResponse response, Object obj) {
		render(response, "text/html;charset=UTF-8", obj);
	}

	/**
	 * 发送json。使用UTF-8编码。
	 */
	public static void renderJson(HttpServletResponse response, Object obj) {
		render(response, "application/json;charset=UTF-8", obj);
	}

	/**
	 * 发送xml。使用UTF-8编码。
	 */
	public static void renderXml(HttpServletResponse response, Object obj) {
		render(response, "text/xml;charset=UTF-8", obj);
	}

	/**
	 * 发送内容。使用UTF-8编码。
	 */
	public static void render(HttpServletResponse response, String contentType,
			Object obj) {
		response.setContentType(contentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(obj);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally{
			if (out!=null) {
				out.flush();
				out.close();
			}
		}
	}
}
