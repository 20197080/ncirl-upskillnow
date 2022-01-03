package ie.ncirl.upskillnow.control.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ie.ncirl.upskillnow.util.UpSkillNowConstants;

/**
 * 
 *
 * @author juarezjunior
 */
public class CcrHttpSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute(UpSkillNowConstants.SHOW_WELCOME_NOTIFICATION_BAR, "true");       
    }

    public void sessionDestroyed(HttpSessionEvent se) {
    	se.getSession().removeAttribute(UpSkillNowConstants.SHOW_WELCOME_NOTIFICATION_BAR);   
    }
}
