package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class ModifyClassId extends ActionSupport {
   @Resource StudentDao  studentDaoImpl;
   private int classId;
   private String result;
   private int sno;
   @JSON(serialize=false)
	 public String getResult() {
		return result;
	  }
	public void setResult(String result) {
		this.result = result;
	}
  @JSON(serialize=false)
   public int getClassId() {
		return classId;
	}
   public void setClassId(int classId) {
		this.classId = classId;
	}
	@JSON(serialize=false)
 public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
	public String execute(){
		studentDaoImpl.modifyClassId(sno, classId);
		result="更改班级正确";
		return SUCCESS;
	}
}
