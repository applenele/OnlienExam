package org.nele.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.ClassDao;
import org.nele.dao.MajorDao;
import org.nele.dao.StudentDao;
import org.nele.dao.TeacherDao;
import org.nele.dao.XueYuanDao;
import org.nele.domain.Major;
import org.nele.domain.Student;
import org.nele.domain.Teacher;
import org.nele.domain.User;
import org.nele.domain.Class;
import org.nele.domain.XueYuan;
import org.nele.utils.ToMd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller  //����Spring���� 
@Scope("prototype")//����ģʽ
public class TeacherLoginAction extends ActionSupport {
	
   @Resource TeacherDao teacherDaoImpl;//ע��TeacherDao�ӿ����ڵ�������ķ���
   @Resource StudentDao studentDaoImpl;//ע��StudentDao�Ľӿ����ڵ�������ķ���
   @Resource ClassDao classDaoImpl;
   @Resource XueYuanDao xueYuanDaoImpl;
   @Resource MajorDao majorDaoImpl;
   private  Map<String,String> map;
   //private Teacher teacher;
   private User user;
   private String class_name;
     
   @JSON(serialize=false)
    public String getClass_name() {
	return class_name;
   }

   public void setClass_name(String class_name) {
	this.class_name = class_name;
  }

	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

   private String result;
   private String verifyCode;
   private String userKind;
   
    @JSON(serialize=false)//����Ҫ�ӣ���ֹSpringì�ܸ�ֵ
	public String getUserKind() {
		return userKind;
	}

	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}

    @JSON(serialize=false)
	   public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

  /*@JSON(serialize=false)
	   public Teacher getTeacher() {
		return teacher;
	 }

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	*/
   @JSON(serialize=false)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JSON(serialize=false)
	   public Map<String, String> getMap() {
		return map;
	  }

  public void setMap(Map<String, String> map) {
	this.map = map;
   }

  /**
   * ��֤��½
   * @author ���� 2013-9-22 nele0716@163
   */
  public String execute(){
	   user.setUserPassword(ToMd5.getMD5(user.getUserPassword()));
	    map=new HashMap<String, String>();
	    String randCode=(String) ActionContext.getContext().getSession().get("rand");//�õ���ʾ����֤�룬��֤����session�ķ�ʽ
	    if(randCode.equals(verifyCode)){//�����֤��������ȷ
	       	/*if(teacherDaoImpl.loginVerify(teacher.getTuserName(),teacher.getTpassword(), randCode)){
	       		map.put("result", "��½�ɹ���");
	       	}else{
	       		map.put("result", "�û��������벻��ȷ");
	       	}*/
	    	if("1".equals(userKind)){//�ж��û�����
	    		Student student=studentDaoImpl.loginVerify(user.getUserName(), user.getUserPassword());
	    		if(student!=null){
	    			map.put("result", "��½�ɹ���");
	    		    Class bj=classDaoImpl.getClassById(student.getClassId());
	    		    System.out.println(bj.getClassGrade());
	    		    Major major=majorDaoImpl.getMajorById(bj.getMajorId());
	    		    XueYuan xy=xueYuanDaoImpl.getXueYuanById(major.getMajorId());
	    		    ActionContext.getContext().getSession().put("bj", bj);
	    		    ActionContext.getContext().getSession().put("major", major);
	    		    ActionContext.getContext().getSession().put("xy", xy);
		    		ActionContext.getContext().getSession().put("user", student);
	    		}
	    		else{
	    			map.put("result", "�û��������벻��ȷ");
	    		}
		    }else{
		    	Teacher teacher=teacherDaoImpl.loginVerify(user.getUserName(),user.getUserPassword());
		    	if(teacher!=null){
		    		map.put("result", "��½�ɹ���");
		    		ActionContext.getContext().getSession().put("user", teacher);
		    	}
		    	else{
		    		map.put("result", "�û��������벻��ȷ");
		    	}
		    }
	    }else{
	    	//��֤�����벻��ȷ
	    	map.put("result", "��֤�벻��ȷ");
	    }
	   return SUCCESS;
   }
}
