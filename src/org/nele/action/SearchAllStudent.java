package org.nele.action;

import java.util.List;

import javax.annotation.Resource;

import org.nele.dao.StudentDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

@Controller  @Scope("prototype")
public class SearchAllStudent extends ActionSupport  {
   @Resource StudentDao studentDaoImpl;
   
   
	public String execute(){
    @SuppressWarnings("rawtypes")
	String result=studentDaoImpl.getPage(1);
    System.out.println(result);
    int count=studentDaoImpl.getAlltudentCount();
    ActionContext.getContext().put("result", result);
    ActionContext.getContext().put("count", count);
    
    return SUCCESS;
    }
}
