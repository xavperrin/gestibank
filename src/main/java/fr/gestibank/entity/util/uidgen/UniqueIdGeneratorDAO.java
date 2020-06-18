package fr.gestibank.entity.util.uidgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gestibank.dao.DataAccessObject;
import fr.gestibank.entity.exception.DataAccessException;
import fr.gestibank.entity.exception.DuplicateKeyException;
import fr.gestibank.entity.exception.ObjectNotFoundException;


public final class UniqueIdGeneratorDAO {

    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "T_COUNTER";

    /**
     * This method is used when a unique id doesn't exist. This method inserts
     * the value '1' into the database. Meaning, 1 is the first identifier.
     *
     * @param name name of the counter
     * @throws DuplicateKeyException is thrown when an identical object is already in the persistent layer
     * @throws DataAccessException   is thrown if there's a persistent problem
     */
    public void insert(final String name) throws DuplicateKeyException, DataAccessException {
        Connection connection = null;
        Statement statement = null;
        final String sql;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            // Insert a Row
            sql = "INSERT INTO " + TABLE + " VALUES ('" + name + "', '1' )";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            if (e.getErrorCode() == DataAccessObject.DATA_ALREADY_EXIST) {
                throw new DuplicateKeyException();
            } else {
                //displaySqlException(e);
                throw new DataAccessException("Cannot insert data into the database", e);
            }
        } finally {
            // Close
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                //displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }
    }

    /**
     * This method returns a database connection.
     *
     * @return a JDBC connection to the petstore database
     * @throws SQLException if a SQl exception if found
     */
    public static final Connection getConnection() throws SQLException {
        final Connection connection;
        connection = DriverManager.getConnection(DataAccessObject.URL_DB, DataAccessObject.USER_DB, DataAccessObject.PASSWD_DB);
        return connection;
    }

	/**
     * This method deletes the counter name from the database.
     *
     * @param name of the counter to be deleted
     * @throws ObjectNotFoundException is thrown if the object id not found in the persistent layer
     * @throws DataAccessException     is thrown if there's a persistent problem
     */
    public void remove(final String name) throws ObjectNotFoundException, DataAccessException {
        Connection connection = null;
        Statement statement = null;
        final String sql;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            // Delete a Row
            sql = "DELETE FROM " + TABLE + " WHERE NAME = '" + name + "'";
            if (statement.executeUpdate(sql) == 0)
                throw new ObjectNotFoundException();

        } catch (SQLException e) {
            //displaySqlException(e);
            throw new DataAccessException("Cannot remove data into the database", e);
        } finally {
            // Close
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                //displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }
    }

    /**
     * This method updates the value of the counter in the database.
     *
     * @param name  of the counter to be updated in the database
     * @param value new value to update
     * @throws ObjectNotFoundException is thrown if the object id not found in the database
     * @throws DataAccessException     is thrown if there's a persistent problem
     */
    public void update(final String name, final int value) throws ObjectNotFoundException, DataAccessException {
        Connection connection = null;
        Statement statement = null;
        final String sql;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            // Update a Row
            sql = "UPDATE " + TABLE + " SET VALUE = '" + value + "' WHERE NAME = '" + name + "' ";

            if (statement.executeUpdate(sql) == 0)
                throw new ObjectNotFoundException();

        } catch (SQLException e) {
            //displaySqlException(e);
            throw new DataAccessException("Cannot update data into the database", e);
        } finally {
            // Close
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                //displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }
    }

    /**
     * This method return the value of the counter from the database.
     *
     * @param name of the counter to be found in the persistent layer
     * @return value of the counter
     * @throws ObjectNotFoundException is thrown if the object id not found in the persistent layer
     * @throws DataAccessException     is thrown if there's a persistent problem
     */
    public int select(final String name) throws ObjectNotFoundException, DataAccessException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        final String sql;
        int value;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            // Select a Row
            sql = "SELECT VALUE FROM " + TABLE + " WHERE NAME = '" + name + "' ";
            resultSet = statement.executeQuery(sql);
            if (!resultSet.next())
                throw new ObjectNotFoundException();

            // Set data to current object
            value = resultSet.getInt(1);

        } catch (SQLException e) {
            //displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database", e);
        } finally {
            // Close
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                //displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }
        return value;
    }
}