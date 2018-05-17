package com.itheima.bos.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import cn.itcast.bos.utils.PinYin4jUtils;

public class PingYin4JTest {
  @Test
	public void test1(){
		//河北省  厂家庄市 桥西区
		String province ="河北省";
		String city ="石家庄市";
		String district="桥西区";
		//简码 -->HBSJZQX
		      province =  province.substring(0, province.length()-1);
		       city= city.substring(0,city.length()-1);
		       district= district.substring(0,district.length()-1);
		       
		       String info = province+city+district;
		       System.out.println(info);
		       String[] headByString = PinYin4jUtils.getHeadByString(info);//输出的是数组
		       System.out.println(headByString);
		       String shortcode = StringUtils.join(headByString);
		       System.out.println(shortcode);  //把数组里面的数据取出来连成串儿
		       
		       //城市编码shijiazhuangqiaoxi 
		       String citycode = PinYin4jUtils.hanziToPinyin(city);
		       //有重载方法 默认的分隔方法为分割符
		       String citycode2 = PinYin4jUtils.hanziToPinyin(city, "");
		       //设置分割符为"@"
		       String citycode3 = PinYin4jUtils.hanziToPinyin(city, "@");
		       System.out.println(citycode2);
		       System.out.println(citycode3);
		       
		       
	}
}
