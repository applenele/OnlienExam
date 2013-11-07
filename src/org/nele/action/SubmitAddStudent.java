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
	
	/**�����ݿ����һ��ѧ��
	 * @author ���� 2013-9-22  nele0716@163.com
	 */
	public String execute(){
		String sex=student.getStudentSex();
		if("1".equals(sex)){
			student.setStudentSex("��");
		}else{
			student.setStudentSex("Ů");
		} 
	
		 studentDaoImpl.addStudent(student); 
		//���ѧ���ɹ����ʼ�
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
