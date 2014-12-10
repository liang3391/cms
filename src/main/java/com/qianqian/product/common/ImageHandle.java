package com.qianqian.product.common;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import com.framelib.dfs.FastDFSUtil;
import com.framelib.utils.DateUtil;
import com.qianqian.product.util.FileUtil;
import com.qianqian.product.util.ImageUtil;



/**
 * Title:ImageHandle
 * @Description:产品图片处理
 * @Create_by:yinsy
 * @Create_date:2014-6-26
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:goods.maxtp 1.0
 */
public class ImageHandle {
	
	private static String tmpPath = Constants.res.getString("tmpPath");
	
	/**
	 * 获取图片
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param inputStream 
	 * @param fileExt 文件拓展名
	 * @param fileSize 文件大小
	 * @param param 要上传的图片类型
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	public static String getImg(InputStream inputStream,String fileExt,Long fileSize,String param) throws Exception{
		String fromPath = getTmpPath(fileExt);
		FileUtil.saveFile(fromPath, inputStream);
		String imagePath = ""; 
		if ("master".equals(param)) {
			imagePath = getDfsPath(getMasterPic(),fromPath,fileExt);
		}else if ("slave".equals(param)) {
			imagePath = getDfsPath(getSlavePic(),fromPath,fileExt);
		}else if ("color".equals(param)) {
			imagePath = getDfsPath(getColorPic(),fromPath,fileExt);
		}else {
			imagePath = getDfsPath(null,fromPath,fileExt);
		}
		return imagePath;
	}
	
	/**
	 * 获取上传到dfs的地址
	 * @Create_by:yinsy
	 * @Create_date:2014-6-26
	 * @param fromPath 原图地址
	 * @param picMap 图片Map
	 * @param fileExt 文件拓展名
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static String getDfsPath(Map<Integer, Integer> picMap,String fromPath,String fileExt) throws Exception{
		StringBuilder sb = new StringBuilder();
		if (picMap==null) {
			return uploadDfs(null,fromPath,fileExt);
		}
		for (Entry<Integer, Integer> entry : picMap.entrySet()) {
			sb.append(uploadDfs(entry.getValue(),fromPath,fileExt)).append(",");
		}
		FileUtil.removeFile(fromPath);
		if (sb.length()>1) {
			return sb.substring(0, sb.length()-1);
		}
		return sb.toString();
	}
	
	
	/**
	 * 上传到dfs
	 * @Create_by:yinsy
	 * @Create_date:2014-7-9
	 * @param imgSize
	 * @param fromPath
	 * @param fileExt
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static String uploadDfs(Integer imgSize,String fromPath,String fileExt) throws Exception{
		String dfsPath = "";
		String toPath = getTmpPath(fileExt);
		if (imgSize!=null) {
			ImageUtil.cutImage(fromPath, toPath, imgSize , imgSize);
		}else {
			toPath = fromPath;
		}
		String[] dfsUrl = FastDFSUtil.uploadFromFile(toPath, fileExt, null);
		dfsPath = dfsUrl[0]+"/"+dfsUrl[1];
		FileUtil.removeFile(toPath);
		return dfsPath;
	}
	
	/**
	 * 获取临时目录
	 * @Create_by:yinsy
	 * @Create_date:2014-6-26
	 * @param ext 拓展名
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static String getTmpPath(String fileExt)throws Exception{
		FileUtil.mkDirs(tmpPath+File.separator+DateUtil.getToday());//生成图片目录
		String fileName = UUID.randomUUID().toString()+Constants.SYMBOL_DOT+fileExt;
		return tmpPath+File.separator+DateUtil.getToday()+File.separator+fileName;
	}
	
	/**
	 * 获取主图的各个尺寸
	 * @Create_by:yinsy
	 * @Create_date:2014-6-26
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static Map<Integer, Integer> getMasterPic(){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(500, 500);	//原图
		map.put(300, 300);	//展示图
		map.put(80, 80);	//缩略图
		map.put(230, 230);	//个人空间图
		map.put(140, 140);	//收藏图
		return map;
	}
	
	/**
	 * 获取从图的各个尺寸
	 * @Create_by:yinsy
	 * @Create_date:2014-6-26
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static Map<Integer, Integer> getSlavePic(){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(500, 500);	//原图
		map.put(300, 300);	//展示图
		map.put(80, 80);	//缩略图
		return map;
	}
	
	/**
	 * 获取颜色图个尺寸
	 * @Create_by:yinsy
	 * @Create_date:2014-6-26
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private static Map<Integer, Integer> getColorPic(){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(300, 300);	//原图
		map.put(35, 35);	//缩略图
		return map;
	}
	
}
