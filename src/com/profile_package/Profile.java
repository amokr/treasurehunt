package com.profile_package;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public class Profile {
	private String id,user_name,email,prof_url,
		college_name,access_token,gender,total_score,current_base_image,current_hint;
	public String getCurrent_base_image() {
		return current_base_image;
	}

	public void setCurrent_base_image(String current_base_image) {
		this.current_base_image = current_base_image;
	}

	public String getCurrent_hint() {
		return current_hint;
	}

	public void setCurrent_image(String current_image) {
		this.current_hint = current_image;
	}

	public String getTotal_score() {
		return total_score;
	}

	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	int nr=0;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getId() {
		
		return id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_name() {
		System.out.println(user_name);
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		System.out.println(email);
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProf_pic() {
		return prof_url;
	}

	public void setProf_pic(String prof_pic) {
		this.prof_url = prof_pic;
	}
	public void store_info()throws Exception{
	try {
	    Connection con;
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ignite","root","162049");
		String str1="select *from user where id=?";
		PreparedStatement pt1=con.prepareStatement(str1);
		pt1.setString(1,id);
		ResultSet rs=pt1.executeQuery();
		if(rs==null){
		    String str="insert into user values(?,?,?,?,?)";
			PreparedStatement pt=con.prepareStatement(str);
				pt.setString(1,id);
				pt.setString(2,user_name);
				pt.setString(3,email);
				pt.setString(4,prof_url);
				pt.setString(5,college_name);
				nr=pt.executeUpdate();
				if(nr>0){
					System.out.println(nr+" Row get updated");
				}
		}
			else System.out.println("NO row get updated");
		con.close();
		}
	  catch(SQLException e) {
	    System.out.println("SQLException caught: " +e.getMessage());
	  }
	}
}
