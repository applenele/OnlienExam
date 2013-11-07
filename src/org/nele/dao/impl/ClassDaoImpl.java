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
     * 传入一个majorOId  在数据库里面查找class中majorId为该majorId的全部的class集合 
     * @author 聂乐 2013-9-22 nele0716@163
     * @param majorId(专业的id)
     * @return 满足传入的majorId的全部的class的集合
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Class> getAllClassBymajorId(int majorId) {
		Session s=sessionFactory.getCurrentSession();
		String hql="from Class as classDemo where classDemo.majorId=?";//创建hql语句
		Query query=s.createQuery(hql);
		
		query.setParameter(0, majorId);
		@SuppressWarnings("unchecked")
		List<Class> list=query.list();
//		int n=list.size();//测试用
//		System.out.println(n);
		return list;
	}

    /***
     * 通过班级班级的id得到班级
     * @author  聂乐 2013-10-8 nele0716@163.com
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Class getClassById(int classId) {
		Session session=sessionFactory.getCurrentSession();
		Class classInfo=new Class();
		classInfo=(Class) session.get(Class.class,classId);
				
		return classInfo;
	}
   
}
