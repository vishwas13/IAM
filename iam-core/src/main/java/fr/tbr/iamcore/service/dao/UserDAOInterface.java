/**
 * 
 */
package fr.tbr.iamcore.service.dao;

import java.util.Collection;

import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;

/**
 * @author mitha
 *
 */
public interface UserDAOInterface {
	
	public void save(User user) throws DAOSaveException;

	public Collection<User> search(User criteria)  throws DAOSearchException ;
	public boolean authenticate(String username, String password) throws DAOSearchException, DAOSaveException;


}
