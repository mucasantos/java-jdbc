package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /* Aqui registra */

		Connection conn = DB.getConnetion();
		
		DB.closeConnection();

	}

}
