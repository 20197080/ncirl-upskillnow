package ie.ncirl.upskillnow.control;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import ie.ncirl.upskillnow.dao.CourseDAO;
import ie.ncirl.upskillnow.model.entities.Courses;
import ie.ncirl.upskillnow.util.UpSkillNowConstants;

/**
 *
 * @author juarezjunior
 */
@ManagedBean("courseMB")
@SessionScoped
public class CourseMB implements Serializable {

	private static final Logger logger = Logger.getLogger(CertificateMB.class.getName());

	private ServletContext servletContext;
	private Integer id;
	private String name;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Integer skillId;
	private String description;
	private String certType;
	private String comments;
	private byte[] photoBytes;
	private UploadedFile uploaded;
	private InputStream photoInputStream;
	private String photoName;
	private String photoContentType;

	private List<Courses> courses;
	private CourseDAO courseDAO;

	public CourseMB() {
		super();
		servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

		if (courseDAO == null) {
			courseDAO = new CourseDAO();
		}
		init();
	}

	public void init() {
		courses = courseDAO.findAllCourses();
	}

	public String cancel() {
		return UpSkillNowConstants.MAIN;
	}

	public String loadMyCourses() {
		courses = courseDAO.findAllCourses();
		return UpSkillNowConstants.COURSE_DETAILS;
	}

	public String deleteCourse(Courses course) {
		logger.log(Level.INFO, "deleteCourse method called...");
		if (courseDAO == null) {
			courseDAO = new CourseDAO();
		}
		boolean isDeleted = courseDAO.deleteCourse(course);
		logger.log(Level.INFO, "Course deleted?: " + isDeleted);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Course Deleted",
				"Course Deleted: " + isDeleted);
		FacesContext.getCurrentInstance().addMessage(null, message);

		this.loadMyCourses();
		return UpSkillNowConstants.MAIN;
	}

	public String saveCourse() {

		logger.log(Level.INFO, "saveCourse method called...");

		Courses newCourse = new Courses();

		newCourse.setName(name);
		newCourse.setDescription(description);
		newCourse.setSkillId(Integer.valueOf(5));
		newCourse.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		newCourse.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		if (courseDAO == null) {
			courseDAO = new CourseDAO();
		}

		courseDAO.createCourse(newCourse);

		Messages.addInfo("certificateForm:coursePanelGrid", "Course added succesfully!");
		return UpSkillNowConstants.ADD_COURSE;
	}

	/**
	 * @return the certType
	 */
	public String getCertType() {
		return certType;
	}

	/**
	 * @param certType the certType to set
	 */
	public void setCertType(String certType) {
		this.certType = certType;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the uploaded
	 */
	public UploadedFile getUploaded() {
		return uploaded;
	}

	/**
	 * @param uploaded the uploaded to set
	 */
	public void setUploaded(UploadedFile uploaded) {
		this.uploaded = uploaded;
	}

	/**
	 * @return the photoBytes
	 */
	public byte[] getPhotoBytes() {
		return photoBytes;
	}

	/**
	 * @param photoBytes the photoBytes to set
	 */
	public void setPhotoBytes(byte[] photoBytes) {
		this.photoBytes = photoBytes;
	}

	/**
	 * @return the photoContentType
	 */
	public String getPhotoContentType() {
		return photoContentType;
	}

	/**
	 * @param photoContentType the photoContentType to set
	 */
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	/**
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * @param photoName the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}



	/**
	 * @return the photoInputStream
	 */
	public InputStream getPhotoInputStream() {
		return photoInputStream;
	}

	/**
	 * @param photoInputStream the photoInputStream to set
	 */
	public void setPhotoInputStream(InputStream photoInputStream) {
		this.photoInputStream = photoInputStream;
	}





	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public static Logger getLogger() {
		return logger;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.sql.Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public java.sql.Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(java.sql.Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
