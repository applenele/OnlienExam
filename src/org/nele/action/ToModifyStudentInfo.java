package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.nele.domain.Student;
import org.nele.utils.ToMd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class ToModifyStudentInfo extends ActionSupport {
    @Resource StudentDao studentDaoImpl;
	private Student student;
	private String newPassword;
	private String result;
	
	@JSON(serialize=false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@JSON(serialize=false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String execute(){
	   if("".equals(student.getStudentPassword())){
		   student.setStudentPassword(studentDaoImpl.getStudentBySno(student.getSno()).getStudentPassword());
	        studentDaoImpl.updateStudent(student);
	        this.setResult("更改成功！");
	   }
	   else{
		boolean  studentIsExist=studentDaoImpl.studentIsExist(student);
		if(!studentIsExist){
			this.setResult("用户名与原始密码不一致！");
		}
		else{
			student.setStudentPassword(ToMd5.getMD5(newPassword));
			studentDaoImpl.updateStudent(student);
			this.setResult("更改成功！");
		}}
		return SUCCESS;
	}
}
