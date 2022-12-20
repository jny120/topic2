package project.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import utils.HibernateUtil;

public class ProjectDao {
	private SessionFactory factory;

	public ProjectDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	// �d��Ҧ��e�U�ץ�
	public List<Project> findAllEntrustProject() {
		String hql = "from project p where p.pj_class Like N\'%�e�U%\'";
		Session session = factory.getCurrentSession();
		List<Project> allEentrust = new ArrayList<>();

		try {
			Query<Project> query = session.createQuery(hql, Project.class);
			allEentrust = query.getResultList();
			return allEentrust;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	// �d��Ҧ��A�Ȯץ�
	public List<Project> findAllServerEentrustProject() {
		String hql = "from project p where p.pj_class Like N\'%�A��%\'";
		Session session = factory.getCurrentSession();
		List<Project> allEentrust = new ArrayList<>();

		try {
			Query<Project> query = session.createQuery(hql, Project.class);
			allEentrust = query.getResultList();
			return allEentrust;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	// �̷�memberID�Ӭd��
	public List<Project> findByMemberId(String memberID) {
		String hql = "from project p where p.memberID = :m";
		Session session = factory.getCurrentSession();
		List<Project> allEentrust = new ArrayList<>();

		try {
			Query<Project> query = session.createQuery(hql, Project.class).setParameter("m", memberID);
			allEentrust = query.getResultList();
			return allEentrust;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	// �̷�pjName�Ӽҽk�d��
	public List<Project> findByPJName(String searchContext) {
		String hql = "from project p where p.pj_Name = :n";
		Session session = factory.getCurrentSession();
		List<Project> allEentrust = new ArrayList<>();

		try {
			Query<Project> query = session.createQuery(hql, Project.class).setParameter("N\'%" + "n" + "%\'",
					searchContext);
			allEentrust = query.getResultList();
			return allEentrust;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	// �̷�pjID�ӧR��
	public boolean deleteByPJID(Integer pjID) {
		Project project = null;
		Session session = factory.getCurrentSession();
		project = session.get(Project.class, pjID);

		if (project != null) {
			session.delete(project);
			return true;
		} else {
			return false;
		}
	}

	// �̷�pjID�ӭק�
	public boolean UpdateByPJID(Project pj) {
		Project project = null;

		if (pj != null) {
			Session session = factory.getCurrentSession();
			project = session.get(Project.class, pj.getPjID());
			session.update(project);
			return true;
		} else {
			return false;
		}
	}

	// �s�W
	public boolean Save(Project pj) {

		if (pj != null) {
			Session session = factory.getCurrentSession();
			session.save(pj);
			return true;
		} else {
			return false;
		}
	}
}
