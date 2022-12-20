package member.model;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.HibernateUtil;

public class MemberDao {
	private static Logger log = LoggerFactory.getLogger(MemberDao.class);
	private SessionFactory factory;
	private Session session;

	public MemberDao() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = factory.getCurrentSession();
	}

	public Member findByMemberIdAndPassword(String memberId, String password) {

		String hql = "from Member m where m.memberId = :memberId and m.password = :password";

		Session session = factory.getCurrentSession();

		try {
			Member result = session.createQuery(hql, Member.class).setParameter("memberId", memberId)
					.setParameter("password", password).getSingleResult();
			return result;
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Member> findAllMember() {
		String hql = "from Member";
		List<Member> resultList=null;
		
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Query<Member> query = session.createQuery(hql, Member.class);
			resultList = query.getResultList();
			session.getTransaction().commit();
			return resultList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Member findByMemberId(String memberId) {
		String hql = "from Member where memberId = :m";
		Session session = factory.getCurrentSession();
		
		try {
			Member member = session.createQuery(hql,Member.class)
					.setParameter("m", memberId)
					.getSingleResult();
			return member;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Member findByMemberPK(Integer pk) {
		log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
		Member member=null;
		String hql = "from Member where memberPk = :m";
		
		Session session = factory.getCurrentSession();
		try {
			member = session.createQuery(hql,Member.class).setParameter("m", pk).getSingleResult();
			return member;
		}catch( Exception e){
			return null;
		}
		
	}
	
	public boolean existsById(String memberId) {
		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用");
		Session session = factory.getCurrentSession();
		
		try {
			if( session.get(Member.class, memberId)!=null ) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public void deleteByMemberId(String memberId) {
		log.info("會員刪除功能之Dao: 檢查會員是否存在");
		Member member = null;
		Session session = factory.getCurrentSession();
		member = session.get(Member.class, memberId);
		
		if( member!=null ) {
			session.delete(member);
			System.out.println("刪除一筆資料");
		}else {
			System.out.println("不存在該會員無法刪除");
		}
	}
	
	public void update(Member mb) {
		log.info("會員註冊功能之Dao: 儲存會員資料");
		Member member = null;
		if( mb!=null ) {
			Session session = factory.getCurrentSession();
			member = session.get(Member.class, mb.getMemberPk());
			session.update(member);
			System.out.println("update member OK");
		}else {
			System.out.println("memberBean is null, pls check");
		}
	}
	
	public void save(Member mb) {
		log.info("會員註冊功能之Dao: 更新會員資料");
//		Session session = factory.getCurrentSession();
		System.out.println("session dao:"+session);
		session.save(mb);
	}
	
	
}

