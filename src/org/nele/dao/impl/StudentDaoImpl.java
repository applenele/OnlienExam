package org.nele.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nele.dao.StudentDao;
import org.nele.domain.Student;
import org.nele.domain.StudentOfsearchInfo;
import org.nele.domain.Teacher;
import org.nele.utils.ToMd5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service @Transactional
public class StudentDaoImpl implements StudentDao {
     @Resource SessionFactory  sessionFactory;
	
     /**
      * 向数据添加一个学生
      * @author 聂乐 2013-9-22 nele0716@163.com
      * @param 一个教师
      * 
      */
	public void addStudent(Student student) {
		student.setStudentPassword(ToMd5.getMD5(student.getStudentPassword()));
		Session s=sessionFactory.getCurrentSession();
		s.save(student);
	}

	/**
	 * 查找全部的学生的信息
	 * @author 聂乐 2013-9-23 nele0716@163.com
	 * @return 返回全部的student的学院，专业，班级，性别，邮箱
	 */
	@SuppressWarnings("deprecation")
	public String searchAllStudent(){
		System.out.println("kanshdllasdn");
        String studentInfo = null;
		Session session=sessionFactory.getCurrentSession();
		
		//转换成jdbc烦人形式
		Connection conn=session.connection();
		ResultSet rs=null;
		try{
//			CallableStatement proc=conn.prepareCall("{call getAllstudent()}");//sql server 不支持resultset中的last 和first方法用下面的方法可以
			
			//调用数据库中的全部的student信息
			CallableStatement proc=conn.prepareCall("{call getAllstudent()}",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=proc.executeQuery();
			if(rs!=null){
				int n=0;
				int count=0;
				while(rs.next()){
					count++;
				}	
				rs.first();
				studentInfo="["; 
				do{
					studentInfo=studentInfo+"{'suserName':'"+rs.getString(2)+"',"+"'xyName':'"+rs.getString(8)+"',"
							+"'majorName':'"+rs.getString(7)+"',"+"'className':'"+rs.getString(5)+"',"+"'classGrade':'"+rs.getString(6)+"',"
							+"'studentSex':'"+rs.getString(3)+"',"+"'email':'"+rs.getString(4)+"',"+"'sno':'"+rs.getString(1)+"'}";
					       n=n+1;
					  if(n!=count){
						  studentInfo=studentInfo+",";
					  }
				}while(rs.next());
				
				studentInfo=studentInfo+"]";
				System.out.println(studentInfo);
			}else{
			}
			
		}catch(Exception e){}finally{
			try{
				rs.close();
			}catch(Exception e){}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentInfo;
		
		/*
		//直接用hibernate的方式
		String hql="{Call getAllstudent()}";
		 //Query query=session.createSQLQuery(hql).addScalar("studentName",Hibernate.STRING).addScalar("studentPassword",Hibernate.STRING);
		  SQLQuery query=session.createSQLQuery(hql);
		  query.addScalar("studentName",Hibernate.STRING);
		  query.addScalar("studentSex",Hibernate.STRING);
		  query.addScalar("email",Hibernate.STRING);
		  query.addScalar("className",Hibernate.STRING);
		  query.addScalar("classGrade",Hibernate.STRING);
		  query.addScalar("majorName",Hibernate.STRING);
		  query.addScalar("xyName",Hibernate.STRING);
		  Iterator result=query.list().iterator();
		  int n=0;
		  studentInfo="["; 
		  while(result.hasNext()){
			  Object[] rows=(Object[]) result.next();
			  String studentName = (String) rows[0];
			  String studentSex = (String) rows[1];
			  String emmail = (String) rows[2];
			  
			  String className = (String) rows[3];
			  String classGrade = (String) rows[4];
			  String majorName = (String) rows[5];
			  String xyName = (String) rows[6];
			  
			  studentInfo=studentInfo+"{'suserName':'"+rs.getString(2)+"',"+"'xyName':'"+rs.getString(8)+"',"
						+"'majorName':'"+rs.getString(7)+"',"+"'className':'"+rs.getString(5)+"',"+"'classGrade':'"+rs.getString(6)+"',"
						+"'studentSex':'"+rs.getString(3)+"',"+"'email':'"+rs.getString(4)+"'}";
				       n=n+1;
				  if(n!=count){
					  studentInfo=studentInfo+",";
		  }
		  //JSONArray jsonArray=JSONArray.fromObject(list);
		   * */
	}
	
   /***
    * 分页查询 查询要显示的页面的结果
    * @author  聂乐 2013-9-24 nele0716@163.com
    * @param  下一页的页数
    */
	public String getPage(int pageIndex) {
		String studentInfo = null;
		int num=0;
		Session session=sessionFactory.getCurrentSession();
		//转换成jdbc烦人形式
		Connection conn=session.connection();
		ResultSet rs=null;
		try{
//			CallableStatement proc=conn.prepareCall("{call getAllstudent()}");//sql server 不支持resultset中的last 和first方法用下面的方法可以
			
			//调用数据库中的全部的student信息
			  CallableStatement proc=conn.prepareCall("{call fenYeGaiFour(?,?)}",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 
			 // proc.registerOutParameter(1, Types.INTEGER);
			  //proc.setString(1, "ex_student");
			  //proc.setString(2, "studentName");
			 // proc.setString(3, "asc");
			  proc.setInt(1, pageIndex);
			  proc.setInt(2,8);
  
			  rs=proc.executeQuery();
		     if(rs!=null){
				int n=0;
				int count=0;
				while(rs.next()){
					count++;
				}
				rs.first();
				studentInfo="["; //拼凑返回的json形式的字符串
				do{
					studentInfo=studentInfo+"{'suserName':'"+rs.getString(3)+"',"+"'xyName':'"+rs.getString(10)+"',"
							+"'majorName':'"+rs.getString(9)+"',"+"'className':'"+rs.getString(7)+"',"+"'classGrade':'"+rs.getString(8)+"',"
							+"'studentSex':'"+rs.getString(5)+"',"+"'email':'"+rs.getString(6)+"',"+"'sno':'"+rs.getString(2)+"',"+"'studentNum':'"+rs.getString(4)+"'}";
					       n=n+1;
					  if(n!=count){
						  studentInfo=studentInfo+",";
					  }
				}while(rs.next());
				
				studentInfo=studentInfo+"]";
			}else{
			}	
		}catch(Exception e){}finally{
			try{
				rs.close();
			}catch(Exception e){}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentInfo;
	}

	
	
	/***
	 * 查找全部学生的记录
	 * @author 聂乐 2013-9-25 nele0716@163.com
	 * @return 全部学生的记录
	 */
	public int getAlltudentCount() {
	   Session session=sessionFactory.getCurrentSession();
	   String hql="select count(*) from Student as student";
	    Query query=session.createQuery(hql);
	    Iterator i=query.iterate();
	    int n=((Long)i.next()).intValue();
		return n;
	}

	/***
	 * 查询学生
	 * @author 聂乐  2013-10-10 nele0716@163.com
	 * 
	 */
	public String searchStudent(StudentOfsearchInfo studentOfsearchInfo) {
		if("".equals(studentOfsearchInfo.getSuserName())||studentOfsearchInfo.getSuserName()==null)
	     {
	    	 studentOfsearchInfo.setSuserName("null");
	     }
		String  studentInfo=null;
		int n=0;
		int count=0;
		Session session=sessionFactory.getCurrentSession();
		
		Connection conn=session.connection();
		ResultSet rs = null;
	   try{
		    CallableStatement proc=conn.prepareCall("{call searchStudent(?,?,?,?,?,?)}",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    
		     proc.setInt(1, studentOfsearchInfo.getXyId());
		     proc.setInt(2, studentOfsearchInfo.getMajorId());
		     proc.setInt(3,studentOfsearchInfo.getClassId());
		     proc.setInt(4, 1);
		     proc.setInt(5, 8);
		     proc.setString(6,studentOfsearchInfo.getSuserName());
		     
		     rs=proc.executeQuery();	
					while(rs.next()){
						count++;
					}
					//System.out.println(count);
					if(count!=0){
					
					rs.first();
					studentInfo="["; //拼凑返回的json形式的字符串
					do{
						studentInfo=studentInfo+"{'suserName':'"+rs.getString(3)+"',"+"'xyName':'"+rs.getString(10)+"',"
								+"'majorName':'"+rs.getString(9)+"',"+"'className':'"+rs.getString(7)+"',"+"'classGrade':'"+rs.getString(8)+"',"
								+"'studentSex':'"+rs.getString(5)+"',"+"'email':'"+rs.getString(6)+"',"+"'sno':'"+rs.getString(2)+"',"+"'studentNum':'"+rs.getString(4)+"'}";
						       n=n+1;
						  if(n!=count){
							  studentInfo=studentInfo+",";
						  }
					}while(rs.next());
					
					studentInfo=studentInfo+"]";
				}else{
				}	
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return studentInfo;
	}

	/***
	 * 得到查询学生的总个数
	 * @author 聂乐 2013-10-10 nele0716@163.com
	 */
	public int getSearchStudentCount(StudentOfsearchInfo studentOfsearchInfo) throws Exception {
		if("".equals(studentOfsearchInfo.getSuserName())||studentOfsearchInfo.getSuserName()==null)
	     {
	    	 studentOfsearchInfo.setSuserName("null");
	     }
		int count=0;
		Session session=sessionFactory.getCurrentSession();
		
		Connection conn=session.connection();
		boolean rs;
		
		try{
			CallableStatement proc=conn.prepareCall("{?=call searchStudentCount(?,?,?,?,?,?)}",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
			 proc.registerOutParameter(1, Types.INTEGER);
			 proc.setInt(2, studentOfsearchInfo.getXyId());
		     proc.setInt(3, studentOfsearchInfo.getMajorId());
		     proc.setInt(4,studentOfsearchInfo.getClassId());
		     proc.setInt(5, 1);
		     proc.setInt(6, 9);
		     proc.setString(7,studentOfsearchInfo.getSuserName());
		     
		     proc.execute();
		     
		     count=proc.getInt(1);
	
		}catch(Exception e){
			throw e;
		}
		return count;
	}

     /***
      * 查询学生结果分页
      * @author 聂乐 2013-10-10 nele0716@163.com
      */
	public String getSearchResultPage(int pageIndex,StudentOfsearchInfo studentOfsearchInfo) {
		if("".equals(studentOfsearchInfo.getSuserName())||studentOfsearchInfo.getSuserName()==null)
	     { //判断是否根据人名查询
	    	 studentOfsearchInfo.setSuserName("null");
	     }
		String studentInfo = null;
		int num=0;
		Session session=sessionFactory.getCurrentSession();
		//转换成jdbc烦人形式
		Connection conn=session.connection();
		ResultSet rs=null;
		try{
			  CallableStatement proc=conn.prepareCall("{call searchStudent(?,?,?,?,?,?)}",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 
			     proc.setInt(1, studentOfsearchInfo.getXyId());
			     proc.setInt(2, studentOfsearchInfo.getMajorId());
			     proc.setInt(3,studentOfsearchInfo.getClassId());
			     proc.setInt(4, pageIndex);
			     proc.setInt(5, 9);
			     proc.setString(6,studentOfsearchInfo.getSuserName());
  
			     rs=proc.executeQuery();		 
		     if(rs!=null){
				int n=0;
				int count=0;
				while(rs.next()){
					count++;
				}
				rs.first();
				studentInfo="["; //拼凑返回的json形式的字符串
				do{
					studentInfo=studentInfo+"{'suserName':'"+rs.getString(3)+"',"+"'xyName':'"+rs.getString(10)+"',"
							+"'majorName':'"+rs.getString(9)+"',"+"'className':'"+rs.getString(7)+"',"+"'classGrade':'"+rs.getString(8)+"',"
							+"'studentSex':'"+rs.getString(5)+"',"+"'email':'"+rs.getString(6)+"',"+"'sno':'"+rs.getString(2)+"',"+"'studentNum':'"+rs.getString(4)+"'}";
					       n=n+1;
					  if(n!=count){
						  studentInfo=studentInfo+",";
					  }
				}while(rs.next());
				
				studentInfo=studentInfo+"]";
			}else{
			}	
		}catch(Exception e){}finally{
			try{
				rs.close();
			}catch(Exception e){}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentInfo;
	}

	
	
	/***
	 * 通过学生的
	 * @author 聂乐 2013-10-11 nele0716@163.com
	 */
	public Student getStudentBySno(int sno) {
		Session session=sessionFactory.getCurrentSession();
		return (Student) session.get(Student.class,sno);
	}

	/***
	 * 判断用户是否存在
	 * @author 聂乐  2013-10-12 nele0716@163.com
	 */
	public boolean studentIsExist(Student student) {
		Session session=sessionFactory.getCurrentSession();
		 student.setStudentPassword(ToMd5.getMD5(student.getStudentPassword()));
		 String hql="from Student as student where student.studentName=? and student.studentPassword=?";
		 
		 Query query=session.createQuery(hql);
	
		 query.setString(0, student.getStudentName());
		 query.setString(1, student.getStudentPassword());
	
	
	   List<Student> studentList=query.list();
	   if(studentList!=null&&studentList.size()!=0){
		   return true;
	   }
		   return false;
		   
		
	}

	/***
	 * 更改一个学生的信息
	 * @author 聂乐 2013-10-12 nele0716@163.com
	 */
	public void updateStudent(Student student) {
		Session session =sessionFactory.getCurrentSession();
		session.update(student);
	}

	
	/***
	 * 学生类型的登陆
	 * @author nele 2013-10-29 nele0716@163.com
	 * @param tuserName 
	 * @param tpassword
	 * @return 如果登陆成功返回已个student 否则返回一个null
	 */
	public Student loginVerify(String tuserName, String tpassword) {
		String hql;
	    Session s= sessionFactory.getCurrentSession();
	    hql="from Student as ex_student where ex_student.studentName=? and ex_student.studentPassword=?";
	    
	    Query query=s.createQuery(hql);
	    
	    query.setParameter(0, tuserName);
	    query.setParameter(1, tpassword);
	    @SuppressWarnings("unchecked")
	    List<Student> list=query.list();
	    if(list!=null&&list.size()!=0){//判断list是否为空
	    	return list.get(0);
	    }
	    else{
	    	return null;	
	    }	
	}

	/***
	 * 更改用户的密码
	 * @author nele nele0716.163.com 2013-11-5
	 * @param sno
	 * @param pwd
	 */
	public void modifyPwd(int sno, String pwd) {
		Session session=sessionFactory.getCurrentSession();
		/*方式一*/
		/*String hql="update Student as student set student.studentPassword=?,where student.sno=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, pwd);
		query.setParameter(1, sno);
		query.executeUpdate();*/
	     
		/*方式二*/
		try{
		Student student=(Student) session.get(Student.class, sno);
		student.setStudentPassword(pwd);
		session.update(student);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/***
	 * 验证是否存在当前用户
	 * @author nele nele0716@163.com 2013-11-5
	 * @param sno
	 * @param perPwd
	 */
	public boolean verifyPrePwd(String s_num, String perPwd) {
		String hql;
	    Session s= sessionFactory.getCurrentSession();
	    hql="from Student as ex_student where ex_student.studentNum=? and ex_student.studentPassword=?";
	    
	    Query query=s.createQuery(hql);
	    
	    query.setParameter(0, s_num);
	    query.setParameter(1, perPwd);
	    @SuppressWarnings("unchecked")
	    List<Student> list=query.list();
	    if(list!=null&&list.size()!=0){//判断list是否为空
	    	 return true;
	    }
	    else{
	    	return false;	
	    }	
	}

	/***
	 * 修改班级id
	 * @author nele nele0716@163.com 2013-11-6
	 * @param sno
	 * @param classid
	 */
	public void modifyClassId(int sno, int classid){
		Session session=sessionFactory.getCurrentSession();
		/*String hql="update Student student set studetn.classId=?,where student.sno=?";
		try{
		Query query=session.createQuery(hql);
		query.setParameter(0, classid);
		query.setParameter(1, sno);
		query.executeUpdate();
		}catch(Exception e){
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}*/
		
		try{
			Student student=(Student) session.get(Student.class, sno);
			student.setClassId(classid);
			session.update(student);
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	
	public void modifyEmail(int sno, String email) {
         Session session=sessionFactory.getCurrentSession();
         try{
        	 Student student=(Student)session.get(Student.class,sno);
        	 student.setEmail(email);
        	 session.update(student);
            }catch(Exception e){
        	 e.printStackTrace();
         }
	}


}
