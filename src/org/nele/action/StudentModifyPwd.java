package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.nele.utils.ToMd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class StudentModifyPwd extends ActionSupport {
     @Resource StudentDao studentDaoImpl;
     public int sno;
     public String pwd;
     public String result;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String execute(){
		String password=ToMd5.getMD5(pwd);
		studentDaoImpl.modifyPwd(sno,password);
		result="更改密码成功";
	    return  SUCCESS;	
	}
}
