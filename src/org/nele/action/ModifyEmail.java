package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class ModifyEmail extends ActionSupport {
    @Resource StudentDao studentDaoImpl;
	
    private int sno;
    private String new_email;
    private String result;
    @JSON(serialize=false)
    public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@JSON(serialize=false)
	public String getNew_email() {
		return new_email;
	}
	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}
	
	public String execute(){
		studentDaoImpl.modifyEmail(sno, new_email);
		result="更改邮箱成功";
		return SUCCESS;
	}
    
    
}
