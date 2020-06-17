package gestibank.dao;

import gestibank.exception.CheckException;
import gestibank.exception.DataAccessException;
import gestibank.exception.DuplicateKeyException;
import gestibank.exception.ObjectNotFoundException;

/*
 * T pour le type souhaité
 * ID pour l'identifiant
 * CRUD pour Create, Retrieve, Update, Delete
 * 
 */
public interface DataAccessObject<T, ID> {

	/**
     * Database error code when we want to insert an id that already exists.
     */
    int DATA_ALREADY_EXIST = 1062;

    /**
     * JDBC Driver class to instanciate.
     */
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * URL of where the database is located.
     */
    String URL_DB = "jdbc:mysql://localhost:3306/gestibankDB";

    /**
     * Username to access the database.
     */
    String USER_DB = "root";

    /**
     * Password to access the database.
     */
    String PASSWD_DB = "root";
	
	public void create(T t) throws DuplicateKeyException, CheckException, DataAccessException; 
	public T retrieve(ID id) throws CheckException;
	public void update(T t) throws ObjectNotFoundException, DuplicateKeyException;
	public void delete(ID id) throws ObjectNotFoundException, CheckException;
	void checkId(final ID id) throws CheckException;
	
	

   
}
