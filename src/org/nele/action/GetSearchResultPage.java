package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.nele.domain.StudentOfsearchInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class GetSearchResultPage extends ActionSupport {
  
	@Resource StudentDao studentDaoImpl;
	
	private String result;
	private int pageIndex;
	private StudentOfsearchInfo studentOfsearchInfo;
	@JSON(serialize=false)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    @JSON(serialize=false)
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
    @JSON(serialize=false)
	public StudentOfsearchInfo getStudentOfsearchInfo() {
		return studentOfsearchInfo;
	}

	public void setStudentOfsearchInfo(StudentOfsearchInfo studentOfsearchInfo) {
		this.studentOfsearchInfo = studentOfsearchInfo;
	}

	public String execute(){
	    this.setResult(studentDaoImpl.getSearchResultPage(pageIndex, studentOfsearchInfo));
		return SUCCESS;
	}
}
