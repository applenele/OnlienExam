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

@Service @Transactional//�Զ�ɨ�裬�Զ���������
public class TeacherDaoImpl implements TeacherDao {
      @Resource SessionFactory sessionFactory;
	 /**
	  * ͨ��id�õ���ʦ����Ϣ
	  * @author ����  2013-09-15  nele0716@163.com
	  * @param ��ʦ��id��
	 * @return һ����ʦ����Ϣ
	  */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Teacher getTeacher(long id) {
        return (Teacher)sessionFactory.getCurrentSession().get(Teacher.class,id);
	}
    
    
    /**
     * ��ʦ��½��֤
     * @author ���� 2013-09-15 nele0716@163.com
     * @param ����֤���û���������
     * @return �Ƿ��и���ʦ
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
	    if(list!=null&&list.size()!=0){//�ж�list�Ƿ�Ϊ��
	    	return list.get(0);
	    }
	    else{
	    	return null;	
	    }	
	}


	/**
	 * ע��һ����ʦ���û�
	 * @author ���� 2013-09-19 nele0716@163.com
	 * @param һ����ʦ�ĵ���Ϣ
	 */
	public void register(Teacher teacher) {
	    Session s=sessionFactory.getCurrentSession();
	    s.save(teacher);
	}
   
}
