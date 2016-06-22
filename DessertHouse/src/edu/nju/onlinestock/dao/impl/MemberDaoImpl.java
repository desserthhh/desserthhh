package edu.nju.onlinestock.dao.impl;

import hibernate3.support.YeekuHibernateDaoSupport;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;






import edu.nju.onlinestock.dao.BaseDao;
import edu.nju.onlinestock.dao.MemberDao;
import edu.nju.onlinestock.model.Allsale;

import edu.nju.onlinestock.model.Manager;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.model.Recharge;


public class MemberDaoImpl extends YeekuHibernateDaoSupport
	implements MemberDao {
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Member save(Member member) {
		Member m = new Member();
		// TODO Auto-generated method stub
		baseDao.save(member);
		System.out.println("save:name:"+member.getName());
		
		m = this.findByTel(member);
		return m;
	}

	@Override
	public boolean findByAccount(Member member) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Member> result = (List<Member>)getHibernateTemplate().
				find("from member as m where "
				+"m.account=?", member.getAccount());
		if(result.size() != 0)
			return true;
		return false;
	}
	
	@Override
	public Member findByTel(Member member) {
		// TODO Auto-generated method stub
		Member m = null;
		String hql = "from edu.nju.onlinestock.model.Member where tel ='"+member.getTel()+"'";
		Session session = baseDao.getNewSession();
		List<Member> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}
		return m;
	}
	
	@Override
	public boolean findByAccountAndPassword(Member member) {
		// TODO Auto-generated method stub
		
		Member m = null;
		String hql = "from edu.nju.onlinestock.model.Member where account ='"+member.getAccount()+"'";
		Session session = baseDao.getNewSession();
		List<Member> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
			System.out.println(m.getPassword());
			if(m.getPassword().equals(member.getPassword()))
				return true;
			else
				return false;
		}else{
			System.out.println("找不到");
			return false;
		}
		
		
	}
	
	

	@Override
	public boolean findByTelAndPassword(Member member) {
		Member m = null;
		String hql = "from edu.nju.onlinestock.model.Member where tel ='"+member.getTel()+"'";
		Session session = baseDao.getNewSession();
		List<Member> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
			System.out.println(m.getPassword());
			if(m.getPassword().equals(member.getPassword()))
				return true;
			else
				return false;
		}else{
			System.out.println("找不到");
			return false;
		}
	}

	@Override
	public Member getMemberByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = null;
		String hql = "from edu.nju.onlinestock.model.Member where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		List<Member> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}else{
			System.out.println("找不到");
		}
		
		return m;
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Member";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

//	@Override
//	public Integer getFemaleNums() {
//		// TODO Auto-generated method stub
//		String hql = "select count(*) from Member as m where m.gender='female'";
//		int nums = ((Long)getHibernateTemplate().iterate(hql).next()).intValue();
//		return nums;
//	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = (Member) baseDao.load(Member.class, account);

		if(m==null){
			return "";
		}else{
			return m.getName();
		}
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		baseDao.update(member);
		
		Member m = this.getMemberByAccount(member.getAccount());
		return m.getClass().equals(member);
	}



	@Override
	public boolean saveRecharge(Recharge recharge) {
		// TODO Auto-generated method stub
		String hql = "select max(r.rid) from edu.nju.onlinestock.model.Recharge r";
		Session session = baseDao.getNewSession();
		int id = (Integer)session.createQuery(hql).uniqueResult();
		System.out.println(id);
		recharge.setRid(id+1);
		baseDao.save(recharge);
		return true;
	}

	@Override
	public List<Recharge> getRecharge(int account) {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Recharge where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public List<Allsale> getAllsale(int account) {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.onlinestock.model.Allsale where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}


}
