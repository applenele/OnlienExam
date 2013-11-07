package org.nele.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.ClassDao;
import org.nele.dao.MajorDao;
import org.nele.dao.StudentDao;
import org.nele.dao.XueYuanDao;
import org.nele.dao.impl.XueYuanDaoImpl;
import org.nele.domain.Major;
import org.nele.domain.StudentOfsearchInfo;
import org.nele.domain.XueYuan;
import org.nele.domain.Class;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.spring.interceptor.ActionAutowiringInterceptor;

@Controller @Scope("prototype")
public class SearchStudent extends ActionSupport {
    @Resource StudentDao studentDaoImpl;
    @Resource XueYuanDao xueYuanDaoImpl;
    @Resource MajorDao majorDaoImpl;
    @Resource ClassDao  classDaoImpl;
    int count;
    private StudentOfsearchInfo studentOfsearchInfo;
    private  String result;
   
    @JSON(serialize=false)
	public StudentOfsearchInfo getStudentOfsearchInfo() {
		return studentOfsearchInfo;
	}

	public void setStudentOfsearchInfo(StudentOfsearchInfo studentOfsearchInfo) {
		this.studentOfsearchInfo = studentOfsearchInfo;
	}

	@JSON(serialize=false )
    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute(){
		
        result=studentDaoImpl.searchStudent(studentOfsearchInfo);
        System.out.println(result);
        try {
			count=studentDaoImpl.getSearchStudentCount(studentOfsearchInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(count);
        ActionContext.getContext().put("result",result);
    	ActionContext.getContext().put("count", count);
    	
    	if("null".equals(studentOfsearchInfo.getSuserName())){
    		 ActionContext.getContext().put("suserName","全部学生查询");
    	}else{
    		ActionContext.getContext().put("suserName",studentOfsearchInfo.getSuserName());
    	}
    	
    	if(studentOfsearchInfo.getXyId()==0){
    		XueYuan xueYuan=new XueYuan();
    		xueYuan.setXyId(0);
    		xueYuan.setXyName("所有学院");
    		ActionContext.getContext().put("xy",xueYuan);
    	}else{
    		ActionContext.getContext().put("xy",xueYuanDaoImpl.getXueYuanById(studentOfsearchInfo.getXyId()));
    	}
    	if(studentOfsearchInfo.getMajorId()==0){
    		Major major=new Major();
    		major.setMajorId(0);
    		major.setMajorName("所有专业");
    		ActionContext.getContext().put("major",major);
    	}else{
    		 ActionContext.getContext().put("major",majorDaoImpl.getMajorById(studentOfsearchInfo.getMajorId()));
    	}
    	if(studentOfsearchInfo.getClassId()==0){
    		Class classeg=new Class();
    	    classeg.setClassId(0);
    	    classeg.setClassGrade("所有班级");
    		ActionContext.getContext().put("bj",classeg);
    	}else{
    		ActionContext.getContext().put("bj", classDaoImpl.getClassById(studentOfsearchInfo.getClassId()));
    	}
        return SUCCESS;
    }
}
