package org.nele.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.ClassDao;
import org.nele.domain.Class;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller//交个 Spring管理
@Scope("prototype") //多例的方式
public class SearchClassByMajorId extends ActionSupport {
       @Resource ClassDao classDaoImpl;//注入classDao接口
       private String majorId;
       private String result;
       @JSON(serialize=false)
       public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
       public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String execute(){
    	 int majorIdInt=Integer.parseInt(majorId);//将前台得到的majorId字符转转成int型
    	   
    	List<Class> list=classDaoImpl.getAllClassBymajorId(majorIdInt);//调用接口的方法得到majorId满足要求的全部的classde集合
    	JSONArray jsonArray=JSONArray.fromObject(list);//将list集合转换成json的格式
    	this.setResult(jsonArray.toString());//将json格式的list转换成字符串赋给result，用于返回给前台
    	   return SUCCESS;
       }
}
