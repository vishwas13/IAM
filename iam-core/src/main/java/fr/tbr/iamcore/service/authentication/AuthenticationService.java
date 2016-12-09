package fr.tbr.iamcore.service.authentication;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.UserDAOInterface;

public class AuthenticationService implements UserDAOInterface {
	
	@Inject
	SessionFactory sf;

	private static final IAMLogger logger = IAMLogManager.getIAMLogger(AuthenticationService.class);
	
	public void setSessionFactory(SessionFactory sf){
		this.sf = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sf;
	}

	@Override
	public void save(User user) throws DAOSaveException {
		// TODO Auto-generated method stub
		logger.info("=> save this identity : " + user);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		logger.info("<= save ok" );
		
	}

	@Override
	public Collection<User> search(User criteria) throws DAOSearchException {
		// TODO Auto-generated method stub
		String hqlString = "from User as user where user.login = :login";
		Session session = sf.openSession();
		Query query = session.createQuery(hqlString);
		query.setParameter("login", criteria.getLogin());
		return (Collection<User>) query.list();
	}

	@Override
	public boolean authenticate(String username, String password) throws DAOSearchException, DAOSaveException {
		
		Collection<User> list = search(new User(username,password));
		for(User user : list){
			if(user.getLogin().equals(username)){
				return true;
			}
		}
		return false;
	}

	

}
