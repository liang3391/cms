package com.qianqian.product.util;

import java.util.ResourceBundle;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

import com.framelib.utils.StringUtil;
import com.qianqian.product.common.Constants;


/**
 * Title:ImageUtil
 * Description: 用im4java对图片进行处理
 * @Create_by:yinsy
 * @Create_date:2013-10-7
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:baoogu 1.0
 */
public class ImageUtil {
	
	/** 
     * ImageMagick的路径 
     */
    public static String imageMagickPath = "";
	
	static{
		ResourceBundle resource = ResourceBundle.getBundle(Constants.IMG_CONFIG_PATH);
		imageMagickPath = resource.getString("imageMagickPath");
	}
	
	/**
     * 根据坐标裁剪默认尺寸的图片
     * @Create_by:yinsy
     * @Create_date:2013-10-7
     * @param fromPath 要裁剪图片的路径
     * @param toPath 裁剪图片后的路径
     * @param xStr 起始横坐标
     * @param yStr 起始纵坐标
     * @param wStr 宽度
     * @param hStr 高度
     * @throws Exception
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:baoogu 1.0
     */
	public static void cutImage(String fromPath,String toPath,String xStr, String yStr,
			String wStr, String hStr) throws Exception {
		cutImage(fromPath, toPath, xStr, yStr, wStr, hStr, 138, 138);
	}  
  
    /**
     * 根据坐标裁剪图片
     * @Create_by:yinsy
     * @Create_date:2013-10-7
     * @param fromPath 要裁剪图片的路径
     * @param toPath 裁剪图片后的路径
     * @param xStr 起始横坐标
     * @param yStr 起始纵坐标
     * @param wStr 宽度
     * @param hStr 高度
     * @param _width 剪裁的宽度
     * @param _hight 剪裁的高度
     * @throws Exception
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:baoogu 1.0
     */
    public static void cutImage(String fromPath,String toPath,String xStr, String yStr,
			String wStr, String hStr,int _width,int _hight) throws Exception {
    	int x = 0, y = 0, w = 0, h = 0;
		if (StringUtil.notEmpty(xStr)) {
			x = Integer.parseInt(xStr);
		}
		if (StringUtil.notEmpty(yStr)) {
			y = Integer.parseInt(yStr);
		}
		if (StringUtil.notEmpty(wStr)) {
			w = Integer.parseInt(wStr);
		}
		if (StringUtil.notEmpty(hStr)) {
			h = Integer.parseInt(hStr);
		}
        IMOperation op = new IMOperation();  
        op.addImage(fromPath);  
        /** 
         * width：  裁剪的宽度 
         * height： 裁剪的高度 
         * x：       裁剪的横坐标 
         * y：       裁剪的挫坐标 
         */
        op.crop(w, h, x, y);
        op.p_repage();	//gif清空图片以外的空白
        if (_width>0) {
        	op.resize(_width, _hight);
		}
        op.addImage(toPath);
        ConvertCmd convert = new ConvertCmd();
        // linux下不要设置此值，不然会报错
        if (StringUtil.notEmpty(imageMagickPath)) {
            convert.setSearchPath(imageMagickPath);
		}
        convert.run(op);
    }
  
    /**
     * 缩放图片
     * @Create_by:yinsy
     * @Create_date:2013-10-7
     * @param fromPath 源图片路径 
     * @param toPath 缩放后图片的路径 
     * @param width 缩放后的图片宽度 
     * @param height 缩放后的图片高度 
     * @param flag true：按原图比例缩放，false：按指定大小缩放
     * @throws Exception
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:baoogu 1.0
     */
    public static void cutImage(String fromPath,String toPath,int width,int height,boolean flag) throws Exception {  
        IMOperation op = new IMOperation();
        op.addImage(fromPath);
        op.coalesce();	//gif图片需要
        if(width == 0){			//根据高度缩放图片  
            op.resize(null, height);
        }else if(height == 0){		//根据宽度缩放图片  
            op.resize(width, null);
        }else {
        	if (flag) {
        		op.resize(width, height);
			}else {
				op.resize(width, height,"!");
			}
        }
        op.addImage(toPath);
        ConvertCmd convert = new ConvertCmd();
        // linux下不要设置此值，不然会报错  
        if (StringUtil.notEmpty(imageMagickPath)) {
            convert.setSearchPath(imageMagickPath);
		}
        convert.run(op);
    }
    
    /**
     * 根据指定尺寸缩放图片
     * @Create_by:yinsy
     * @Create_date:2013-10-7
     * @param fromPath 源图片路径 
     * @param toPath 缩放后图片的路径 
     * @param width 缩放后的图片宽度 
     * @param height 缩放后的图片高度 
     * @throws Exception
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:baoogu 1.0
     */
    public static void cutImage(String fromPath,String toPath,int width,int height) throws Exception {  
       cutImage(fromPath, toPath, width, height, false);
    }  

	public static void main(String[] args) throws Exception {
		cutImage("E:/images/aaa.jpg", "E:/images/aaa_1.jpg",400,400);
	}

}