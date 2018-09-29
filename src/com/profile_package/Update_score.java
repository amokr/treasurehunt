package com.profile_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Udate_score
 */
@WebServlet(description = "verifing the answer and updating the score", urlPatterns = { "/Update_score" })
public class Update_score extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String rans = request.getParameter("ans");
		HttpSession session=request.getSession(false); 
		Profile pobj=(Profile)session.getAttribute("fb_session");
		String id=pobj.getId();
		int q_id=0,t_question=15,r_time=5;  // total question by default set to 15 and time to 5min
		String cans=null;
		PreparedStatement pt;
		Connection con = null;
		String query;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ignite","root","162049");
		    query="Select q_id from user_score where id=?";
		    pt=con.prepareStatement(query);
		    pt.setString(1,id);
		    ResultSet rs=pt.executeQuery();
		    while(rs.next()){
		    	q_id=rs.getInt(1);
		    }
		     query ="Select ans from questions where id=?";
		     pt=con.prepareStatement(query);
		     rs=pt.executeQuery();
		     while(rs.next()){
		    	cans=rs.getString(1); 
		     }
		     if(rans!=cans){
		    	 // redirect to same page with same status
		     }
		     else{
		    	 if(q_id<=t_question){
		    		 query="Update user_score set q_id=?,hint_no=?,remaning_time=? where id=?";
		    		 try {
		 				pt =con.prepareStatement(query);
		 				pt.setInt(1,q_id+1);
		 				pt.setInt(2,1);
		 				pt.setInt(3,r_time);
		 				pt.setString(4,id);
		 				int nr=pt.executeUpdate();
		 				if(nr>0){
		 					System.out.println("new question updated");
		 					RequestDispatcher next_page =request.getRequestDispatcher("/Upload_questions.java");
		 			    	next_page.forward(request,response);
		 				}
		 				else {System.out.println("Error on updateing the q_id in score_table");}
		 			} catch (SQLException e) {
		 				e.printStackTrace();
		 			}
		    		 
		    	 }else{
		    		 System.out.println("Game over");
		    		 // redirect to his profile page
		    	 }
		     }
		}catch (ClassNotFoundException | SQLException e) {
				System.out.println("calss not found"+ e.getMessage());
		}finally{
			try {
				con.close();
				System.out.println("connection close");
			} catch (SQLException e) {
				System.out.println("Error in closing the connection : "+e.getMessage());
			}
		}
		
	}
}
