package com.qianqian.product.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public class BeanUtil {
	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Object convertMap(Class type, Map map)
	        throws IntrospectionException, IllegalAccessException,
	        InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo
		        .getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);

				Object[] args = new Object[1];
				args[0] = value;

				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Map convertBean(Object bean) throws IntrospectionException,
	        IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo
		        .getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, null);
				}
			}
		}
		return returnMap;
	}

	/**
	 * 将一个 bean 对象转化为一个 CLASS类型的对象
	 * 
	 * @param original
	 *            要转化的JavaBean对象
	 * @param cla
	 *            转化后的新JavaBean对象的CLASS
	 * @return 转化出来的 对象
	 */
	public static Object convertBean(Object original, Class<?> cla)
	        throws Exception {
		if (original == null) {
			return null;
		} else {
			Object obj = null;
			try {
				obj = BeanUtil.convertMap(cla, BeanUtil.convertBean(original));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}
	}

	/**
	 * 转换list中bean类类型
	 * 
	 * @param list
	 *            要转化的list对象
	 * @param cla
	 *            要转换后的cla
	 * @return 转化出来的 list
	 */
	public static List<?> convertListBean(List<?> list, Class<?> cla)
	        throws Exception {
		List<Object> resultList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				resultList.add(BeanUtil.convertBean(o, cla));
			}
		}
		return resultList;
	}
}
