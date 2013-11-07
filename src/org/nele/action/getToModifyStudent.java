package org.nele.action;

import java.util.List;

import javax.annotation.Resource;

import org.nele.dao.ClassDao;
import org.nele.dao.MajorDao;
import org.nele.dao.StudentDao;
import org.nele.dao.XueYuanDao;
import org.nele.domain.Major;
import org.nele.domain.Student;
import org.nele.domain.Class; 
import org.nele.domain.XueYuan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class getToModifyStudent extends ActionSupport {
     @Resource StudentDao studentDaoImpl;
     @Resource MajorDao majorDaoImpl;
     @Resource ClassDao classDaoImpl;
     @Resource XueYuanDao xueYuanDaoImpl;
        private String  sno;

		public String getSno() {
			return sno;
		}
		
		public void setSno(String sno) {
			this.sno = sno;
		}		  
		
		public String execute(){
		  Student student=studentDaoImpl.getStudentBySno(Integer.parseInt(sno));
		  int classId=student.getClassId();
		  Class classInfo=classDaoImpl.getClassById(classId);
		  Major major=majorDaoImpl.getMajorById(classInfo.getMajorId());
		  
		  XueYuan xueYuan=xueYuanDaoImpl.getXueYuanById(major.getXyId());
		  
		  List<XueYuan> allXueYuan=xueYuanDaoImpl.getAllXueYuan();
		  
		  List<Major> allMajor=majorDaoImpl.getAllMajorByXueYuanId(xueYuan.getXyId());
		  
		  List<Class> allClass=classDaoImpl.getAllClassBymajorId(major.getMajorId());
		  
		  ActionContext.getContext().put("allXueYuan", allXueYuan);
		  ActionContext.getContext().put("allMajor", allMajor);
		  ActionContext.getContext().put("allClass", allClass);
		  
		  ActionContext.getContext().put("xueYuan", xueYuan);
		  ActionContext.getContext().put("major", major);
		 ActionContext.getContext().put("classInfo", classInfo);
		 
		  
		  ActionContext.getContext().put("student", student);
			return SUCCESS;
		}
}
