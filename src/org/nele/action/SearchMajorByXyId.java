package org.nele.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.MajorDao;
import org.nele.domain.Major;
import org.nele.domain.XueYuan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class SearchMajorByXyId extends ActionSupport {
	@Resource MajorDao majorDaoImpl;

	private String xyId;
	private String result;
	@JSON(serialize=false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public String getXyId() {
		return xyId;
	}
	public void setXyId(String xyId) {
		this.xyId = xyId;
	}
	
	/**
	 * 查到传入满足xueYuanId全部的major集合
	 * @author 聂乐 2013-9-22 nele0716@163.com
	 */
	public String execute(){
		
		  int xueYuanId=Integer.parseInt(xyId);
		  List<Major> list=new ArrayList<Major>();
     	  list=majorDaoImpl.getAllMajorByXueYuanId(xueYuanId);
    	
     	  JSONArray jsonArray=JSONArray.fromObject(list);
     	  this.setResult(jsonArray.toString());
//    	  int n=list.size();
//    	  System.out.println("list显示"+n);
//         System.out.println(list);
//    	  major=list.get(0);
//    	  System.out.println(major.getMajorName());
    	  return SUCCESS;
      }
	
}
