package com.qianqian.product.common;

import java.util.ResourceBundle;


/**
 * Title:Constant
 * @Description:常量配置
 * @Create_by:yinsy
 * @Create_date:2014-5-26
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class Constants {
	/**图片配置*/
	public static final String IMG_CONFIG_PATH =  "/conf/image";
	/**获取图片资源*/
	public static final ResourceBundle res = ResourceBundle.getBundle(IMG_CONFIG_PATH);
	/** 最大文件大小*/
	public static final int MAX_SIZE = 1000000;
	/** 产品初始版本*/
	public static final int PRD_VER_FIRST = 1;
	/** 图片类型*/
	public static final String IMAGE_TYPE = "jpg,jpeg,png,bmp";
	/** flash类型*/
	public static final String FLASH_TYPE = "swf,flv";
	/** 媒体类型*/
	public static final String MEDIA_TYPE = "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb";
	/** 文件类型*/
	public static final String FILE_TYPE = "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2";
	/** 规格颜色*/
	public static final String PRD_STAND_COLOR = "色";
	/** 裸价产品*/
	public static final int PRD_STD = 0;
	/** 免费产品*/
	public static final int PRD_STD_FREE = 1;
	/** 待售产品*/
	public static final int PRD_STD_FOR_SALE = 1;
	/** 在售产品*/
	public static final int PRD_STD_ONSELL = 2;
	/** 回收站产品*/
	public static final int PRD_STD_RECYCLE_BIN = 3;
	/** 不显示*/
	public static final int PRD_SHOW_NO = 1;
	/** 显示*/
	public static final int PRD_SHOW = 1;
	/** 编辑状态，未编辑*/
	public static final int EDIT_STATUS = 0;
	/** 编辑状态，已编辑*/
	public static final int EDIT_STATUS_YES = 1;
	/** 最新产品*/
	public static final int PRD_SHOW_FLAG = 1;
	/** 历史产品*/
	public static final int PRD_SHOW_FLAG_OLD = 0;
	/** */
	public static final String SYMBOL_DOT =".";
	
	/** 产品规格鞋码*/
	public static final String PRD_DICT_SHOES = "shoes";
	/** 产品规格颜色*/
	public static final String PRD_DICT_COlOR = "color";
	/** 产品规格服饰码*/
	public static final String PRD_DICT_CLOTHES = "clothes";
	
    /** 产品信息表*/
    public final static String PRD_PRODUCT_MONGO = "prd_product";
    /** 产品活动表*/
    public final static String PRD_PRODUCT_ACTIVITY_MONGO = "prd_product_activity";
    /** 产品规格表*/
    public final static String PRD_PRODUCT_STANDARD_MONGO = "prd_product_standard";
    /** 产品详情表*/
    public final static String PRD_PRODUCT_DETAIL_MONGO = "prd_product_detail";
    /** 产品图片表*/
    public final static String PRD_PRODUCT_PICTURE_MONGO = "prd_product_picture";
    /** 产品版本表*/
    public final static String PRD_PRODUCT_VERSION_MONGO = "prd_product_version";
    
    
    //==================ProductActivity======================
    
    /** 等待活动开始*/
    public final static Integer ACT_STAT_WAIT = 1;
    /** 等待活动审核*/
    public final static Integer ACT_STAT_WAIT_CK = 1;
    /** 格式化日期格式*/
    public final static String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm";
    
    /**体验中*/
    public final static Integer NAKED_ACT_STAT_ING = 2;
    /**体验结束*/
    public final static Integer NAKED_ACT_STAT_END = 3;
    
    /**活动终止类型  自动*/
    public final static Integer ACT_END_STAT_AUTO = 0;
    /**活动终止类型  强制*/
    public final static Integer ACT_END_STAT_FORCE = 1;
    
    //==============免费试用================
    /** 等待申请开始*/
    public final static Integer FREE_ACT_STAT_WAIT = 21;
    /** 申请中*/
    public final static Integer FREE_ACT_STAT_ING = 22;
    /** 审核中*/
    public final static Integer FREE_ACT_STAT_CHECK = 23;
    /** 订单提交中*/
    public final static Integer FREE_ACT_STAT_SUB = 24;
    /** 试用结束*/
    public final static Integer FREE_ACT_STAT_END = 25;
    
    /** 自动审核时间*/
    public final static Integer AUTO_HANDLE_TIME_CHECK = 3;
    /**自动重新申报时间*/
    public final static Integer AUTO_HANDLE_TIME_REPORT= 3;
    
    /** 免费试用 用户申请期时间*/
    public final static Integer FREE_ACT_TIME_APPLY = 7;
    /** 免费试用 品牌审核期时间*/
    public final static Integer FREE_ACT_TIME_CHECK = 5;
    /** 免费试用 用户订单提交期时间*/
    public final static Integer FREE_ACT_TIME_SUBMIT = 7;

}


