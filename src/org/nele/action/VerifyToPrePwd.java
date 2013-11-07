package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.nele.utils.ToMd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class VerifyToPrePwd extends ActionSupport {
    @Resource StudentDao  studentDaoImpl;
    public String prePwd;
    public String s_num;
    public String result="";
    @JSON(serialize=false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public String getPrePwd() {
		return prePwd;
	}
	public void setPrePwd(String prePwd) {
		this.prePwd = prePwd;
	}
   @JSON(serialize=false)
	public String getSno() {
		return s_num;
	}

	public void setSno(String s_num) {
		this.s_num = s_num;
	}

	public String execute(){
		String passswordOfMd5=ToMd5.getMD5(prePwd);
		boolean isExist=studentDaoImpl.verifyPrePwd(s_num, passswordOfMd5);
		if(isExist)
			 result="原始密码正确";
		else 
		    result="原始密码不正确";
    	return SUCCESS;
    }
}
