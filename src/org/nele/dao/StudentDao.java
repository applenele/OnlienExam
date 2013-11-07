package org.nele.dao;

import java.util.List;

import org.nele.domain.Student;
import org.nele.domain.StudentOfsearchInfo;

public interface StudentDao {
     public void addStudent(Student student);
     public String searchAllStudent();
     public int getAlltudentCount();
     public String getPage(int pageIndex);
     
     public String  searchStudent(StudentOfsearchInfo StudentOfsearchInfo);
     
     public int getSearchStudentCount(StudentOfsearchInfo StudentOfsearchInfo) throws Exception;
     public String getSearchResultPage(int pageIndex,StudentOfsearchInfo studentOfsearchInfo);
     
     public Student getStudentBySno(int sno);
     
     public boolean studentIsExist (Student student);
     
     public void updateStudent(Student student);
     
     public Student loginVerify(String tuserName,String tpassword);
     
     public void modifyPwd(int sno,String pwd);
     
     public boolean verifyPrePwd(String s_num,String perPwd);
     
     public void modifyClassId(int sno,int classid);
     
     public void modifyEmail(int sno,String email);
}
