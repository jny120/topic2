package evaluation.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import utils.HibernateUtil;

public class EvaluationDao {
	private SessionFactory factory;
	
	public EvaluationDao() {
		factory = HibernateUtil.getSessionFactory();
	}

	//依照pjID來查詢
	public List<Evaluation> findByPJID(Integer pjID) {
		String hql = "from evaluation e where e.pj_ID = :p";
		List<Evaluation> resultList = new ArrayList<>();
		
		Session session = factory.getCurrentSession();
		
		try {
			Query<Evaluation> query = session.createQuery(hql, Evaluation.class)
					.setParameter("p", pjID);
			resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//依照memberID來查詢
	public List<Evaluation> findBymemberID(String memberID) {
		String hql = "from evaluation e where e.memberID = :m";
		List<Evaluation> resultList = new ArrayList<>();
		
		Session session = factory.getCurrentSession();
		
		try {
			Query<Evaluation> query = session.createQuery(hql, Evaluation.class)
					.setParameter("m", memberID);
			resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//新增
	public boolean save(Evaluation ev) {
		
		if (ev != null) {
			Session session = factory.getCurrentSession();
			session.save(ev);
			return true;
		} else {
			return false;
		}
	}
}

