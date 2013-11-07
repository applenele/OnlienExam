package org.nele.action;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class VerifyCode extends ActionSupport {
    public String verifyCode;
    public String result;
    
    @JSON(serialize=false)
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@JSON(serialize=false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute(){
		
		String randCode=(String) ActionContext.getContext().getSession().get("rand");//�õ���ʾ����֤�룬��֤����session�ķ�ʽ
		
		if(verifyCode.equals(randCode)){
		  this.setResult("��֤����ȷ");	
		}else{
			this.setResult("��֤�����");
		}
		
		return SUCCESS;
	}
	
}
