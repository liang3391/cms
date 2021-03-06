package com.qianqian.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.framelib.dfs.FastDFSUtil;

/**
 * FastDFS上传删除文件的 Controller
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.demo.UploadController.java
 * @ClassName : UploadController
 * @Author : zhangyan
 * @CreateDate : 2014-4-17 下午3:08:53
 */
@Controller
@RequestMapping("/dfs")
public class UploadController {
	private static Logger log = LoggerFactory.getLogger(UploadController.class);
	/**
	 * 批量上传文件
	 * @Method_Name : upload
	 * @param files 
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws Exception
	 * @return : String
	 * @Creation Date : 2014-4-17 下午3:09:29
	 * @version : v1.00
	 * @Author : zhangyan
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping(value = "/upload")
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile[] files,
			HttpServletRequest request,  ModelMap model) throws IOException,
			Exception {
		List<String> filePathList = new ArrayList<String>();
		if(null!=files){
			for(int i=0;i<files.length;i++){
				String type = FilenameUtils.getExtension(files[i].getOriginalFilename());
				String[] results = FastDFSUtil.uploadFile(files[i].getBytes(), type, null);
				String fileName = results[0] + "/" + results[1];				
				//将上传的图片保存到当前用户的图片空间
				filePathList.add(fileName);
			}
		}
		log.debug("filePathList="+Arrays.toString(filePathList.toArray()));
		model.put("filePathList",filePathList);

		return "common/upload/uploaddfsResult";
	}
	
	/**
	 * 删除文件
	 *  @Method_Name    : delete
	 *  @param filePath ：文件路径 ,组名+文件名；如group1/M00/00/00/wKgKeVJyEz5AjE3AAfttt24PQ968.jpg
	 *  @param request
	 *  @param model
	 *  @return
	 *  @throws IOException
	 *  @throws Exception 
	 *	@return 		: String 
	 *  @Creation Date  : 2014-4-17 下午3:15:03
	 *  @version        : v1.00
	 *  @Author         : zhangyan 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping(value = "/delete")
	public String delete(String filePath, HttpServletRequest request,
			ModelMap model) throws IOException, Exception {
		String groupName = filePath.split("\\/")[0];
		String remoteFileName = filePath.substring(groupName.length() + 1);
		//返回0 表示成功，否则失败
		int result = FastDFSUtil.deleteFile(groupName, remoteFileName);
		model.put("result", result);
		return "common/upload/uploaddfsResult";
	}

}
