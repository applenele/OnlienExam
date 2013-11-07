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

@Service //service 交个Spring管理
@Transactional  //hibernate自动管理事物
public class MajorDaoImpl implements MajorDao {
    @Resource SessionFactory sessionFactory; 
    
	/**
	 *通过学院的id得到全部的学院id为输入参数的全部major的集合
	 * @author 聂乐 2013-9-21 nele0716@163.com
	 * @param 学院的id
	 * @return 后的学院id为输入参数的全部的major集合
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Major> getAllMajorByXueYuanId(int xyId) {
		
	 Session s=sessionFactory.getCurrentSession();//得到当前的session(hiberante)
	 String hql="from Major as major where major.xyId=?";//创建hql语句
	 
	 Query query=s.createQuery(hql);//创建查询
	 
	 query.setParameter(0, xyId);//给占位符赋值
	 
	 List<Major> list=query.list();//query查询返回满足要求的list集合
//	 int n=list.size();//测试的用
//	 System.out.println("list显示impl"+n);
	  return list;
	}

	/***
	 * 通过专业的id得到专业
	 * @author 聂乐 2013-10-8 nele0716@163.com
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Major getMajorById(int majorId) {
		Session session=sessionFactory.getCurrentSession();
		Major major=new Major();
		major=(Major) session.get(Major.class, majorId);

		return major;
	}

}
