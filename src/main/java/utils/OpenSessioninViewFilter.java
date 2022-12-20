package utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebFilter(urlPatterns = {"/login.do","/regist/regist.do"})

public class OpenSessioninViewFilter extends HttpFilter implements Filter {

	private Session session;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			this.session = factory.getCurrentSession();
//			this.session = factory.openSession();
			System.out.println("session filter"+session);
			
			session.beginTransaction();
			System.out.println("Begin Transation");
			
			chain.doFilter(request, response);
			
//			System.out.println("1:"+session.toString());
			session.getTransaction().commit();
			System.out.println("Session commit!");
			
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("rollback!");
			e.printStackTrace();
		}finally {
			System.out.println("Session Close!");
//			session.close();
			
		}
		
		
	}


}
