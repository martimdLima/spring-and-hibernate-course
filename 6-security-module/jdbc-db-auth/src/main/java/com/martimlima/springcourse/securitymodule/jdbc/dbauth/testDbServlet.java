package com.martimlima.springcourse.securitymodule.jdbc.dbauth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup the connection variables
		
		String user = "springuser";
		String password = "v5QaZsg2pDJqWb7f";
		
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/spring_security_demo_plaintext";
		String driver = "org.mariadb.jdbc.Driver";
		
		// get a connection to the database
				
		
		try {
			
			PrintWriter out = response.getWriter();
			
			System.out.println("Connecting to database: " + jdbcURL + "...");
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println("Connection successful");
			
			connection.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
