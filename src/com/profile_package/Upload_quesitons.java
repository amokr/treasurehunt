package com.profile_package;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Uploade_quesiton")
    public class Upload_quesitons extends HttpServlet {
	/*static{
		System.out.println("hello.............1.");
	}*/
    	private static final long serialVersionUID = 1L;
    	    private final String UPLOAD_DIRECTORY = "D:/ignite/login_page/WebContent/WEB-INF/Image";
    	    @Override
    	    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	        //process only if its multipart content
    	    	System.out.println("hello.............2");
    	        if(ServletFileUpload.isMultipartContent(request)){
    	        	System.out.println("hello.............3");
    	            try {
    	            	 System.out.println("hello.............4");
    	                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    	                //System.out.println("hello.............5");
    	                for(FileItem item : multiparts){
    	                    if(!item.isFormField()){
    	                        String name = new File(item.getName()).getName();
    	                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
    	                    }
    	                }
    	               //File uploaded successfully
    	               request.setAttribute("message", "File Uploaded Successfully");
    	            } catch (Exception ex) {
    	            	 System.out.println("hello.............5");
    	               request.setAttribute("message", "File Upload Failed due to " + ex);
    	            }          
    	        }
    	        else{
    	            request.setAttribute("message","Sorry this Servlet only handles file upload request");
    	        }
    	       // request.getRequestDispatcher("/result.jsp").forward(request, response);
    	    }
			/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				System.out.println("hello");
				doPost(request, response);
			}*/
}
