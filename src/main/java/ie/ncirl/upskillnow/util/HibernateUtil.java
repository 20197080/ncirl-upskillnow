package ie.ncirl.upskillnow.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				
				sessionFactory = new Configuration()				
						.addAnnotatedClass(ie.ncirl.upskillnow.model.entities.Courses.class)
						.addAnnotatedClass(ie.ncirl.upskillnow.model.entities.Users.class)
						.addAnnotatedClass(ie.ncirl.upskillnow.model.entities.Skills.class)
						.addAnnotatedClass(ie.ncirl.upskillnow.model.entities.CourseContents.class)	
						.configure("hibernate.cfg.xml").buildSessionFactory();				
			}
			return sessionFactory;
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
