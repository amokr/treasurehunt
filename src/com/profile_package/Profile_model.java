package com.profile_package;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Profile_model{
	public static void main(String arg[]) throws Exception{
		//Profile_model obj=new Profile_model();
		//obj.call_me(access_token);
	}
	
	public Profile call_me(String access_token) throws Exception {
		// in url we can mention the height and width of profile picture  and all other filds which we needed
	     String url ="https://graph.facebook.com/v3.1/me?fields=id%2Cname%2Cemail%2Cpicture.width(150).height(150)%2Cgender&access_token="+access_token;
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     // creating the object of profile class
	     
	     Profile pobj=new Profile();   
	     //Read JSON response and print
	        JSONObject myResponse = new JSONObject(response.toString());
	        //System.out.println("id:- "+myResponse.getString("id"));
	        // setting the value of id
	        pobj.setId(myResponse.getString("id"));
	        //System.out.println("Name:- "+myResponse.getString("name"));
	        // setting the name
	        pobj.setUser_name(myResponse.getString("name"));
	        //System.out.println("email:- "+myResponse.getString("email"));
	        pobj.setEmail(myResponse.getString("email"));
	        JSONObject pic=myResponse.getJSONObject("picture");
	        JSONObject data_pic=pic.getJSONObject("data");
	        //System.out.println("URL:- "+data_pic.getString("url"));
	        //setting the image
	        pobj.setProf_pic(data_pic.getString("url"));
	        // setting gender of student
	        pobj.setGender(myResponse.getString("gender"));
	        pobj.setCollege_name("NITK");
	        pobj.setAccess_token("access_token");
	        return pobj;
	   }
}
