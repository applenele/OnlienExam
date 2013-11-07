package org.nele.action;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;


import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.TeacherDao;
import org.nele.dao.impl.TeacherDaoImpl;
import org.nele.domain.Teacher;
import org.nele.mail.GetMailSend;
import org.nele.utils.ToMd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller //����Spring����  
@Scope("prototype")
public class TeacherRegisterAction extends ActionSupport {
	@Resource TeacherDao teacherDaoImpl;
	private Map<String,String> map;
	private String majorId;
	@JSON(serialize=false)
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	private Teacher teacher;
	@JSON(serialize=false)
    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@JSON(serialize=false)
     public Map<String, String> getMap() {
		return map;
	} 

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	  
  /**
   * �û�ע����֤  �û�ע��
   * @author ���� 2013-9-22 nele0716@163
   */
	public String execute(){
	     teacher.setTpassword(ToMd5.getMD5(teacher.getTpassword()));
	     teacher.setMajorId(Integer.parseInt(majorId));
    	 map=new HashMap<String, String>();
    	 
    	 teacherDaoImpl.register(teacher);
    	 
    	 //ע��ɹ����ʼ�
    	/*try {
    		 teacherDaoImpl.register(teacher);
			 GetMailSend.sendMail(teacher.getEmail());
		} catch (FileNotFoundException e) {
		} catch (MessagingException e) {
			e.printStackTrace();
	  }*/
    	 map.put("result", "ע��ɹ�������������䷢��ȷ����Ϣ");
    	 return SUCCESS;
     }
}
