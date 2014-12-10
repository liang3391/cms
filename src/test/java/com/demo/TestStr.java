package com.demo;

import java.util.Date;

import com.framelib.utils.DateUtil;

public class TestStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = "ddd".split(",");
		String sd = "2014/05/29 21:12:30";
		Date date = DateUtil.parse(sd, "yyyy/MM/dd HH:mm:ss");
		System.out.println(date);
	}

}
