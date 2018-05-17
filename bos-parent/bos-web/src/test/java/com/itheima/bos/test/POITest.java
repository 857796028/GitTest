package com.itheima.bos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {

//如果解析xml文件
   @Test
   public void test1() throws FileNotFoundException, IOException{
	String filePath = "D:\\VideoJava\\BOS-day05\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";//导入文件
	//使用poi 把内容都读出来
	//包装一个Excel文件对象
	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
	//读取文件中第一个Sheet1 标签页
     HSSFSheet hssfSheet  =	workbook.getSheetAt(0);
     //遍历标签页中所有的行
     for (Row row : hssfSheet) {
    	 //第一行标题不存入数据库,知道第一次循环就行
    	 
    	int rowNum = row.getRowNum();//获得行号
    	if(rowNum == 0){
    		continue;   //如果是本次循环  就结束本次循环,进行下一次循环.
    	} 
    	
		 //遍历单元格
    	 System.out.println(); //每一行循环完之后来一个回车
    	 for (Cell cell : row) {
			  String v1 = cell.getStringCellValue();
			 // System.out.println(v1); 打印的是一列
			    System.out.print(v1+"   "); //变成一行
		}
	}
   }
   
}
