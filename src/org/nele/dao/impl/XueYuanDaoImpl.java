package org.nele.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nele.dao.XueYuanDao;
import org.nele.domain.XueYuan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional 
public class XueYuanDaoImpl implements XueYuanDao {
    @Resource SessionFactory sessionFactory;
	
    /**
     * �õ�ȫ����ѧԺ�ĵļ���
     * @author ���� 2013-9-21 nele0716@163.com
     * @param 
     * @return �õ�ȫ��ѧԺ�ĵļ���
     */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<XueYuan> getAllXueYuan() {
		Session s=sessionFactory.getCurrentSession();
		String hql="from XueYuan";
		Query query=s.createQuery(hql);
		
		List<XueYuan> list=query.list();
		return list;
	}

	
	
	/***
	 * ͨ��ѧԺ�ĵ�id�õ�ѧԺ
	 * @author ����  2013-10-8 nele0716@163.com
	 * @param ѧԺ��id
	 * @return �õ���ѧԺ
	 * 
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public XueYuan getXueYuanById(int XyId) {
		Session session=sessionFactory.getCurrentSession();
		XueYuan xueYuan=new XueYuan();
		xueYuan=(XueYuan) session.get(XueYuan.class, XyId);
	
		return xueYuan;
	}

}
