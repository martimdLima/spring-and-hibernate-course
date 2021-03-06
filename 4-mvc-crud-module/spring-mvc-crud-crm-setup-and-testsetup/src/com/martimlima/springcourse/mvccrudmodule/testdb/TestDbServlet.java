package com.martimlima.springcourse.mvccrudmodule.testsetup.testdb;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup connection variables
		String user = "springuser";
		String pass = "v5QaZsg2pDJqWb7f";
		
		//String jdbcUrl = "jdbc:mariadb://localhost:3306/spring?user=root&password=v5QaZsg2pDJqWb7f";
		String jdbcUrl = "jdbc:mariadb://127.0.0.1:3306/spring";
		String driver = "org.mariadb.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.print(myConn.toString()); 
			
			out.println("SUCCESS!!!");
			
			myConn.close();
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	
	
	}

}

