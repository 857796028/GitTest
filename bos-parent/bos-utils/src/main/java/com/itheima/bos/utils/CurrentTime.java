package com.itheima.bos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentTime {
	public static void getTime() {  
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));//定义时区，可以避免虚拟机时间与系统时间不一致的问题  
          
        //System.out.println(new Date(System.currentTimeMillis()));//方法一：默认方式输出现在时间  
         
        Date nowTime = new Date();  
      //  System.out.println(nowTime);//方法二：Date方式，输出现在时间  
  
        SimpleDateFormat matter = new SimpleDateFormat(  
                "现在时间:yyyy年MM月dd日E HH时mm分ss秒SSS纳秒"+"..."+System.currentTimeMillis());  
        
        System.out.println(matter.format(nowTime));//方法三：SimpleDateFormat方式，完整输出现在时间  
     
    }  
  
}
