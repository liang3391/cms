package com.qianqian.naked.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.utils.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.qianqian.common.model.Image;
import com.qianqian.naked.service.IImageService;
/**
 * 操作图片的控制器
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.controller.ImageController.java
 * @ClassName	: ImageController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月23日 上午11:34:42
 */
@Controller
@RequestMapping("/image")
public class ImageController {
	@Resource
	private IImageService imageService;
	/**
	 * 增加图片，保存到图片空间
	 *  @Method_Name    : addImage
	 *  @param model
	 *  @param image
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月23日 上午11:42:09
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("add")
	public String addImage(Model model,Image image){
		/*
		 封装image对象
		 */
		imageService.addImage(image);
		model.addAttribute("image", image);
		return null;
	}
	/**
	 * 删除图片
	 *  @Method_Name    : delete
	 *  @param imageId
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月23日 上午11:52:32
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("delete")
	public String delete(Image image,ModelMap map){
		imageService.deleteImage(image);
		map.put("result", 1);
		return null;
	}
	/**
	 * 图片空间下的所有图片
	 *  @Method_Name    : getImageList
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月23日 上午11:51:53
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getAll")
	public String getImageList(PageBounds page, Model model){
		List<Image> images=null;
		page.setLimit(10);
		images=imageService.getAllImage(100l,page);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageList<Image> pageList = (PageList) images;
		model.addAttribute("allCount", pageList.getPaginator().getTotalCount());
		model.addAttribute("allPage", pageList.getPaginator().getTotalPages());
		model.addAttribute("currentPage", page.getPage());
		model.addAttribute("images", images);
		return "naked/includes/image";
	}
	/**
	 * 图片空间下的所有图片
	 *  @Method_Name    : getImageList
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月23日 上午11:51:53
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getAllByName")
	public String getImageListByName(Model model,PageBounds page,String imageName){
		List<Image> images=null;
		page.setLimit(10);
		if(StringUtil.isBlank(imageName)){
			images=imageService.getAllImage(100l,page);
		}else{
			images=imageService.getAllImage(100l,imageName,page);
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageList<Image> pageList = (PageList) images;
		model.addAttribute("allCount", pageList.getPaginator().getTotalCount());
		model.addAttribute("allPage", pageList.getPaginator().getTotalPages());
		model.addAttribute("currentPage", page.getPage());
		model.addAttribute("images", images);
		return "naked/includes/imageDiv";
	}
	
}
