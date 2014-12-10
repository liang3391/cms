package com.qianqian.product.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * Title:FileUtil
 * @Description:文件处理工具类
 * @Create_by:yinsy
 * @Create_date:2014-6-4
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class FileUtil {

	/**
	 * 保存文件
	 * @param path 文件的全路径
	 * @param is 文件内容的输入流
	 * @return
	 * @throws Exception
	 */
	public static void saveFile(String path, InputStream is) throws Exception {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			byte[] buffer = new byte[1024];
			int n = -1;
			while ((n = is.read(buffer)) != -1) {
				fos.write(buffer, 0, n);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}

	/**
	 * 删除文件
	 * 
	 * @param parentPath
	 *            文件所在的上级目录
	 * @param fileName
	 *            文件名称
	 * @throws Exception
	 */
	public static void removeFile(String parentPath, String fileName)
			throws Exception {
		String path = parentPath + File.separator + fileName;
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}
	
	/**
	 * 删除文件
	 * @param parentPath  文件所在的上级目录
	 * @param fileName    文件名称
	 * @throws Exception
	 */
	public static void removeFile(String filePath)throws Exception{
		File file = new File(filePath);
		if(file.exists() && file.isFile()){
			file.delete();
		}
	}

	/**
	 * 移动文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @param oldPath
	 *            文件原来的上级目录
	 * @param newPath
	 *            文件新的上级目录
	 * @throws Exception
	 */
	public static void moveFile(String fileName, String oldPath, String newPath)
			throws Exception {
		copyFile(fileName, oldPath, newPath);
		String oldFileName = oldPath + fileName;
		File file = new File(oldFileName);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param oldPath
	 *            原文件的上级目录
	 * @param newPath
	 *            新文件的上级目录
	 * @throws Exception
	 */
	public static void copyFile(String fileName, String oldPath, String newPath)
			throws Exception {
		String oldFileName = oldPath + fileName;
		String newFileName = newPath + fileName;
		copyFile(oldFileName, newFileName);
	}

	/**
	 * 文件内容复制
	 * 
	 * @param oldFileName
	 *            需要被复制的文件
	 * @param newFileName
	 *            需要的文件
	 * @throws Exception
	 */
	public static void copyFile(String oldFileName, String newFileName)
			throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(oldFileName);
			fos = new FileOutputStream(newFileName);
			byte[] buffer = new byte[1024];
			int n = -1;
			while ((n = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, n);
			}
			fos.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	/**
	 * 创建目录
	 * 
	 * @param file
	 *            目录
	 */
	public static void markDirs(File file) {
		if (file != null && !file.exists()) {
			file.mkdirs();
		}
	}
	
	/**
	 * 创建目录
	 * 
	 * @param path 目录
	 */
	public static void mkDirs(String path){
		File file = new File(path);
		markDirs(file);
	}

	/**
	 * 获取图片文件名称,如：1.jpg
	 * 
	 * @param imgPath
	 *            图片路径
	 * @return
	 */
	public static String getSimpleName(String imgPath) {
		int index = imgPath.lastIndexOf("/");
		if (index >= 0) {
			return imgPath.substring(index);
		}
		index = imgPath.lastIndexOf("\\");
		if (index >= 0) {
			return imgPath.substring(index);
		}
		return imgPath;
	}

	/**
	 * 方法描述：上传图片文件 2013-11-14上午10:11:09
	 * 
	 * @Create_by:guoxz
	 * @param inputStream
	 *            输入流
	 * @param fileName
	 *            文件名
	 * @return File 输入成功的文件
	 */
	public static File wirteFile(InputStream inputStream, String fileName) {

		File file = new File(fileName);
		OutputStream output = null;
		try {
			output = new FileOutputStream(file);
			IOUtils.copy(inputStream, output);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
