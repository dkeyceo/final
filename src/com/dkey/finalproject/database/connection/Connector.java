package com.dkey.finalproject.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connector {
	private static InitialContext ic;
	private static DataSource ds;
	private static final String DATASOURCE_NAME = "java:/comp/env/jdbc/mydb";

	public static Connection getConnection() throws SQLException, NamingException {
		ic = new InitialContext();
		ds = (DataSource) ic.lookup(DATASOURCE_NAME);
		return ds.getConnection();
	}

}
