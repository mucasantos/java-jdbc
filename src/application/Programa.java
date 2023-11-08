package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) throws SQLException {
	
		Connection conn = DB.getConnetion();
		
		DB.closeConnection();

	}

}
