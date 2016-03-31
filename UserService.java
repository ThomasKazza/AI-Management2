package services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.mindrot.jbcrypt.BCrypt;

import pojos.User;



@ManagedBean(name="userService")
@RequestScoped
public class UserService {
	private User user;
	
	
	public UserService(){
		this.user = new User();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String printIT(){
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		 String  originalPassword = "password";
	     String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
	     System.out.println(generatedSecuredPasswordHash);
	     boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	     System.out.println(matched);
	//	user.setUsername(null);
	//	user.setPassword(null);
		UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
		return view.getViewId() + "?faces-redirect=true";
	}
	
}
