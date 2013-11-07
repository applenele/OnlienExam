package org.nele.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nele.dao.MajorDao;
import org.nele.domain.Major;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service //service ����Spring����
@Transactional  //hibernate�Զ���������
public class MajorDaoImpl implements MajorDao {
    @Resource SessionFactory sessionFactory; 
    
	/**
	 *ͨ��ѧԺ��id�õ�ȫ����ѧԺidΪ���������ȫ��major�ļ���
	 * @author ���� 2013-9-21 nele0716@163.com
	 * @param ѧԺ��id
	 * @return ���ѧԺidΪ���������ȫ����major����
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Major> getAllMajorByXueYuanId(int xyId) {
		
	 Session s=sessionFactory.getCurrentSession();//�õ���ǰ��session(hiberante)
	 String hql="from Major as major where major.xyId=?";//����hql���
	 
	 Query query=s.createQuery(hql);//������ѯ
	 
	 query.setParameter(0, xyId);//��ռλ����ֵ
	 
	 List<Major> list=query.list();//query��ѯ��������Ҫ���list����
//	 int n=list.size();//���Ե���
//	 System.out.println("list��ʾimpl"+n);
	  return list;
	}

	/***
	 * ͨ��רҵ��id�õ�רҵ
	 * @author ���� 2013-10-8 nele0716@163.com
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Major getMajorById(int majorId) {
		Session session=sessionFactory.getCurrentSession();
		Major major=new Major();
		major=(Major) session.get(Major.class, majorId);

		return major;
	}

}
