package org.nele.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.nele.dao.XueYuanDao;
import org.nele.domain.XueYuan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class AddStudent extends ActionSupport {
	 @Resource XueYuanDao xueYuanDaoimpl;
	
	public String execute(){
		
		List<XueYuan> list=new ArrayList<XueYuan>();
		list=xueYuanDaoimpl.getAllXueYuan();
		XueYuan xueYuan=new XueYuan();
		
//		xueYuan=list.get(0);
//		System.out.println(xueYuan.getXyName());
		//System.out.println(list);
		ActionContext act=ActionContext.getContext();//获得request
		act.put("xyList", list);//给request赋值传给页面端
		return SUCCESS;
	}
}
