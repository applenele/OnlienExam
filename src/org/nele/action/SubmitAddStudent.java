package org.nele.action;

import java.io.FileNotFoundException;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.StudentDao;
import org.nele.domain.Student;
import org.nele.mail.GetMailSend;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class SubmitAddStudent extends ActionSupport {
    @Resource StudentDao  studentDaoImpl;
	private Student student;
	@JSON(serialize=false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**向数据库添加一个学生
	 * @author 聂乐 2013-9-22  nele0716@163.com
	 */
	public String execute(){
		String sex=student.getStudentSex();
		if("1".equals(sex)){
			student.setStudentSex("男");
		}else{
			student.setStudentSex("女");
		} 
	
		 studentDaoImpl.addStudent(student); 
		//添加学生成功发邮件
		/*
             try {
				  studentDaoImpl.addStudent(student); 
				GetMailSend.sendMail(student.getEmail());
           } catch (FileNotFoundException e) {	
  				e.printStackTrace();
               } catch (MessagingException e) {
 				e.printStackTrace();
   		}*/
		
	  
		return SUCCESS;
	}
	
}
