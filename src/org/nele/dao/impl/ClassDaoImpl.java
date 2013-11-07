package org.nele.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nele.dao.ClassDao;
import org.nele.domain.Class;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ClassDaoImpl implements ClassDao {
    @Resource SessionFactory sessionFactory;
	
    /**
     * ����һ��majorOId  �����ݿ��������class��majorIdΪ��majorId��ȫ����class���� 
     * @author ���� 2013-9-22 nele0716@163
     * @param majorId(רҵ��id)
     * @return ���㴫���majorId��ȫ����class�ļ���
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Class> getAllClassBymajorId(int majorId) {
		Session s=sessionFactory.getCurrentSession();
		String hql="from Class as classDemo where classDemo.majorId=?";//����hql���
		Query query=s.createQuery(hql);
		
		query.setParameter(0, majorId);
		@SuppressWarnings("unchecked")
		List<Class> list=query.list();
//		int n=list.size();//������
//		System.out.println(n);
		return list;
	}

    /***
     * ͨ���༶�༶��id�õ��༶
     * @author  ���� 2013-10-8 nele0716@163.com
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Class getClassById(int classId) {
		Session session=sessionFactory.getCurrentSession();
		Class classInfo=new Class();
		classInfo=(Class) session.get(Class.class,classId);
				
		return classInfo;
	}
   
}
