package com.profile_package;
import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Read_image", description = "Validation for starting the game cheking wether use started first time", urlPatterns = { "/Read_question" })
public class Read_question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int total_question=15;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("hello");
		HttpSession session=request.getSession(false); 
		Profile pobj=(Profile)session.getAttribute("fb_session");
		 
		 // Variables
		 Connection con = null;
		 String id=pobj.getId();  //  reading id from user profile
		 int q_no=-1,r_time=5,nr=0;
		 PreparedStatement pt1=null,pt2=null;
		//System.out.println("current user id: "+id);
		 
		 try{
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ignite","root","162049");
		    String query="Select q_id, hint_no from user_score where id= ?";
		    pt1 =con.prepareStatement(query);
		    pt1.setString(1,id);
		    ResultSet rs=pt1.executeQuery();
		   // System.out.println("hi..."+rs);
		    while(rs.next()){ q_no=rs.getInt(1);}
		    
		    // check is user, first time starting the game if yes update the user_score table
		    if(q_no==-1){
		    	System.out.println("New user started the game, updating the user_score table");
		    	String query1="Insert into user_score values(?,?,?,?)";
		    	pt2=con.prepareStatement(query1);
		    	pt2.setString(1,id);
		    	pt2.setInt(2,1);
		    	pt2.setInt(3,1);
		    	pt2.setInt(4,r_time);
		    	nr=pt2.executeUpdate();
				if(nr>0){
					System.out.println(nr+" Row get updated");
				}
				else{System.out.println("Error on updatation");}
		    }
		    // forwarding to Upload_queston
		    if(q_no>total_question){
		    	// redirect to user profile with pop message saying you all ready finish the game
		    	request.setAttribute("info","you all ready finish the game");
		    	
		    	RequestDispatcher next_page =request.getRequestDispatcher("/student_profile.jsp");
		    	next_page.forward(request,response);
		    }
	    	System.out.println("Moving to page Question_update");
	    	request.setAttribute("info","from_read_question_page");
	    	RequestDispatcher next_page =request.getRequestDispatcher("/Question_update");
    		next_page.forward(request,response);
    		System.out.println("hooooooooooo");
		 }catch(SQLException e) {
			    System.out.println("SQLException caught: " +e.getMessage());
		 } catch (ClassNotFoundException e) {
			System.out.println("calss not found"+ e.getMessage());
		}finally{
			  try {
				pt1.close();
				pt2.close();
			    con.close();
			} catch (SQLException e) {
				System.out.println("Error on closeing the connection : " +e.getMessage());
			}
		}
	}
}