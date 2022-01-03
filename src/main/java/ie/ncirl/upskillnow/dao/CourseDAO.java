package ie.ncirl.upskillnow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ie.ncirl.upskillnow.model.entities.Courses;
import ie.ncirl.upskillnow.util.HibernateUtil;


/**
 *
 * @author juarezjunior
 */
public class CourseDAO {


	private SessionFactory sessionFactory = null;

	public CourseDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public boolean updateCourse(Courses toUpdate) {
		if (toUpdate != null) {
			boolean wasUpdated = this.updateCourse(toUpdate);
			if (wasUpdated) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean createCourse(Courses newCourse) {
		if (newCourse != null) {
			
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			session.save(newCourse);
			session.flush();
			txn.commit();
			return true;
		}
		return false;
	}

	public boolean deleteCourse(Courses toDelete) {
		if (toDelete != null) {
			return true;
		}
		return false;
	}

	public Courses findCourse(Courses toFind) {
		if (toFind != null) {
			return null;
		}
		return null;
	}

	public Courses findCourseById(String id) {
		if (id != null) {
			return null;
		}
		return null;
	}

	public List<Courses> findAllCourses() {
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();		
		List<Courses> courses = 
		session.createQuery("SELECT c FROM Courses c", Courses.class).getResultList();			
		session.flush();
		txn.commit();		
		return courses;

	}

	public List<Courses> findMyOwnCourses(String userName) {

		if (userName != null) {
			return null;
		}
		return null;
	}
}
