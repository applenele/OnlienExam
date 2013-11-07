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
     * 得到全部的学院的的集合
     * @author 聂乐 2013-9-21 nele0716@163.com
     * @param 
     * @return 得到全部学院的的集合
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
	 * 通过学院的的id得到学院
	 * @author 聂乐  2013-10-8 nele0716@163.com
	 * @param 学院的id
	 * @return 得到的学院
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
