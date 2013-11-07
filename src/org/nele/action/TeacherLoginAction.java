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


@Controller  //交给Spring管理 
@Scope("prototype")//多例模式
public class TeacherLoginAction extends ActionSupport {
	
   @Resource TeacherDao teacherDaoImpl;//注入TeacherDao接口用于调用里面的方法
   @Resource StudentDao studentDaoImpl;//注入StudentDao的接口用于调用里面的方法
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
   
    @JSON(serialize=false)//必须要加，防止Spring矛盾赋值
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
   * 验证登陆
   * @author 聂乐 2013-9-22 nele0716@163
   */
  public String execute(){
	   user.setUserPassword(ToMd5.getMD5(user.getUserPassword()));
	    map=new HashMap<String, String>();
	    String randCode=(String) ActionContext.getContext().getSession().get("rand");//得到显示的验证码，验证码是session的方式
	    if(randCode.equals(verifyCode)){//如果验证码输入正确
	       	/*if(teacherDaoImpl.loginVerify(teacher.getTuserName(),teacher.getTpassword(), randCode)){
	       		map.put("result", "登陆成功！");
	       	}else{
	       		map.put("result", "用户名或密码不正确");
	       	}*/
	    	if("1".equals(userKind)){//判读用户类型
	    		Student student=studentDaoImpl.loginVerify(user.getUserName(), user.getUserPassword());
	    		if(student!=null){
	    			map.put("result", "登陆成功！");
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
	    			map.put("result", "用户名或密码不正确");
	    		}
		    }else{
		    	Teacher teacher=teacherDaoImpl.loginVerify(user.getUserName(),user.getUserPassword());
		    	if(teacher!=null){
		    		map.put("result", "登陆成功！");
		    		ActionContext.getContext().getSession().put("user", teacher);
		    	}
		    	else{
		    		map.put("result", "用户名或密码不正确");
		    	}
		    }
	    }else{
	    	//验证码输入不正确
	    	map.put("result", "验证码不正确");
	    }
	   return SUCCESS;
   }
}
