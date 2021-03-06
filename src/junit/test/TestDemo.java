package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.nele.dao.TeacherDao;
import org.nele.domain.Teacher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestDemo {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}
	
	@Test 
	public void test(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	 
   TeacherDao teacherDao=(TeacherDao) ctx.getBean("teacherDaoImpl");
	  
	  
	 Teacher teacher=teacherDao.getTeacher(9);
     System.out.println(teacher.getEmail());
	}

}
