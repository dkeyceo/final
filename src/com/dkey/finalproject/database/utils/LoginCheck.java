package com.dkey.finalproject.database.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dkey.finalproject.database.connection.Connector;

public class LoginCheck {
	private static boolean isSuccess;
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static boolean check(String login, String password) {
		try {
			if (conn == null)
				conn = Connector.getConnection();
			ps = conn.prepareStatement("select user_id from users where login = ? and password = ?");
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			isSuccess = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
