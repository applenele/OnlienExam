package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class GetPage extends ActionSupport {
   @Resource StudentDao studentDaoImpl;
   private String pageIndex;
   private String result;
   @JSON(serialize=false)
	   public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
  @JSON(serialize=false)
	   public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String execute(){
		   this.setResult(studentDaoImpl.getPage(Integer.parseInt(pageIndex)));
		   return SUCCESS;
	   }
}
