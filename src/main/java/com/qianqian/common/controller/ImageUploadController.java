package com.qianqian.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
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
import com.framelib.utils.StringUtil;
import com.qianqian.common.model.Image;
import com.qianqian.common.utils.Constants;
import com.qianqian.naked.service.IImageService;

/**
 * FastDFS上传和删除图片的 Controller
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.demo.UploadController.java
 * @ClassName : UploadController
 * @Author : caozhifei
 * @CreateDate : 2014-5-17 下午3:08:53
 */
@Controller
@RequestMapping("/dfs/image")
public class ImageUploadController {
	private static Logger log = LoggerFactory
			.getLogger(ImageUploadController.class);
	@Resource
	private IImageService imageService;

	/**
	 * 批量上传文件
	 * 
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
			HttpServletRequest request, String imageName, String imageSize,
			ModelMap model) throws IOException, Exception {
		List<String> filePathList = new ArrayList<String>();
		String[] imageSizes = null;
		String[] imageNames = null;
		if (!StringUtil.isBlank(imageSize)) {
			imageSizes = imageSize.split(",");
		}
		if (!StringUtil.isBlank(imageName)) {
			imageNames = imageName.split(",");
		}
		if (null != files) {
			for (int i = 0; i < files.length; i++) {
				BufferedImage image = ImageIO.read(files[i].getInputStream());
				String type = FilenameUtils.getExtension(files[i]
						.getOriginalFilename());
				//判断是否允许上传的图片类型
				if (Constants.IMAGE_TYPES.contains(type.toLowerCase())) {
					String[] results = FastDFSUtil.uploadFile(
							files[i].getBytes(), type, null);
					String fileName = results[0] + "/" + results[1];
					String size = null;
					if (imageSizes == null) {
						size = image.getWidth() + "*" + image.getHeight()
								+ "px";
					} else {
						size = imageSizes[i];
					}
					// 将上传的图片保存到当前用户的图片空间
					long userId = 1l;//当前登录用户ID
					imageService.addImage(new Image(fileName, imageNames[i],
							size,userId,userId));
					filePathList.add(fileName);
				}
			}
		}
		log.debug("filePathList=" + Arrays.toString(filePathList.toArray()));
		model.put("filePathList", filePathList);

		return "common/upload/uploaddfsResult";
	}

	/**
	 * 删除文件
	 * 
	 * @Method_Name : delete
	 * @param filePath
	 *            ：文件路径
	 *            ,组名+文件名；如group1/M00/00/00/wKgKeVJyEz5AjE3AAfttt24PQ968.jpg
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws Exception
	 * @return : String
	 * @Creation Date : 2014-4-17 下午3:15:03
	 * @version : v1.00
	 * @Author : zhangyan
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping(value = "/delete")
	public String delete(String filePath, HttpServletRequest request,
			ModelMap model) throws IOException, Exception {
		String groupName = filePath.split("\\/")[0];
		String remoteFileName = filePath.substring(groupName.length() + 1);
		// 返回0 表示成功，否则失败
		int result = FastDFSUtil.deleteFile(groupName, remoteFileName);
		model.put("result", result);
		return "common/upload/uploaddfsResult";
	}

}
