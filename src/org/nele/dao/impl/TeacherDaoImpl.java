package org.nele.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nele.dao.TeacherDao;
import org.nele.domain.Teacher;
import org.nele.utils.ToMd5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional//自动扫描，自动管理事物
public class TeacherDaoImpl implements TeacherDao {
      @Resource SessionFactory sessionFactory;
	 /**
	  * 通过id得到老师的信息
	  * @author 聂乐  2013-09-15  nele0716@163.com
	  * @param 老师的id的
	 * @return 一个老师的信息
	  */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Teacher getTeacher(long id) {
        return (Teacher)sessionFactory.getCurrentSession().get(Teacher.class,id);
	}
    
    
    /**
     * 老师登陆验证
     * @author 聂乐 2013-09-15 nele0716@163.com
     * @param 待验证的用户名和密码
     * @return 是否有该老师
     */
	@SuppressWarnings("null")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Teacher loginVerify(String tuserName, String tpassword) {
		String hql;
	    Session s= sessionFactory.getCurrentSession();
	 
	    	 hql="from Teacher as ex_teacher where ex_teacher.tuserName=? and ex_teacher.tpassword=?";
	    
	    Query query=s.createQuery(hql);
	    
	    query.setParameter(0, tuserName);
	    query.setParameter(1, tpassword);
	    
	    @SuppressWarnings("unchecked")
	    List<Teacher> list=query.list();
	    if(list!=null&&list.size()!=0){//判断list是否为空
	    	return list.get(0);
	    }
	    else{
	    	return null;	
	    }	
	}


	/**
	 * 注册一个老师的用户
	 * @author 聂乐 2013-09-19 nele0716@163.com
	 * @param 一个老师的的信息
	 */
	public void register(Teacher teacher) {
	    Session s=sessionFactory.getCurrentSession();
	    s.save(teacher);
	}
   
}
