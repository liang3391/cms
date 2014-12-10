package com.qianqian.naked.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.common.model.Image;

/**
 * 对图片的操作
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.IImageService.java
 * @ClassName	: IImageService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月23日 上午11:12:49
 */
public interface IImageService {
	/**
	 * 增加图片
	 *  @Method_Name    : addImage
	 *  @param image 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月23日 上午11:14:10
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	void addImage(Image image);
	/**
	 * 删除图片
	 *  @Method_Name    : deleteImage
	 *  @param image 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月23日 上午11:14:59
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	void deleteImage(Image image);
	/**
	 * 通过空间id查找空间下的图片
	 *  @Method_Name    : getAllImage
	 *  @param spaceId
	 *  @return 
	 *  @return         : List<Image>
	 *  @Creation Date  : 2014年5月23日 上午11:53:54
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<Image> getAllImage(Long spaceId,PageBounds page); 
	/**
	 * 通过空间id和文件名称查找空间下的图片
	 *  @Method_Name    : getAllImage
	 *  @param spaceId
	 *  @return 
	 *  @return         : List<Image>
	 *  @Creation Date  : 2014年5月23日 上午11:53:54
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<Image> getAllImage(Long spaceId,String imageName,PageBounds page); 
}
