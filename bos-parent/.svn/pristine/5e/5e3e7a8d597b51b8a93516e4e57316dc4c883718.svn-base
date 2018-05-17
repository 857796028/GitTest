package com.itheima.bos.utils;
/**
 * 封装分页的属性
 * @author Administrator
 *
 */

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
public class PageBean{
	
	private int currentPage;//当前页码
	private int pageSize;//每页显示的记录数
	private DetachedCriteria detachedCriteria;//查询条件
	private int total;//总记录数
	private List rows;//当前页需要展示的数据集合
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
  
	/*
	   private int currentPage;//当前页码
	   private int pageSize;//每页显示的条数
	   private int  total;//总记录数
	   private List rows; //当前页需要展示的数据集合
	   //总条数不需要
	   private DetachedCriteria detachedCriteria;//离线查询条件对象 在做分页的同时,带一些条件过来
	   
	   
	   
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	
	
	*/
}
