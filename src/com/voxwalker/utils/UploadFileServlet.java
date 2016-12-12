package com.voxwalker.utils;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServlet
 */
// url pattern
@WebServlet("/UploadFileServlet")
// file size options
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10, maxRequestSize=1024*1024*50)
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// folder to save file
	private static final String SAVE_DIR="book_img";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get absolute path of web app
		String appPath =  request.getServletContext().getRealPath("");
		System.out.println( "path= " +appPath);
		String savePath = appPath + File.separator + SAVE_DIR;
		
		// create save dir 
		File fileSaveDir = new File(savePath);
		if(!fileSaveDir.exists()){
			fileSaveDir.mkdir();
		}
		//
		System.out.println("how many parts = " + request.getParts().size());
		
		for( Part part: request.getParts()){
			String fileName = extractFileName(part);
			
			System.out.println("filename = " + fileName +" "+part.getName() +"=" + part.getSize());
			part.write(savePath + File.separator + fileName);
			
		}
		
		request.setAttribute("message", "upload has been done successfully");
		request.getRequestDispatcher("/fileupload/message.jsp").forward(request, response);
		
		
		
	}

	/**
	 * get file name from header : content-disposition
	 * @param part
	 * @return
	 */
	private String extractFileName(Part part) {
		 String contentDisp = part.getHeader("content-disposition");
		 String[] items = contentDisp.split(";");
		 for(String s: items){
			 if(s.trim().startsWith("filename")){
				 return s.substring(s.indexOf("=") + 2, s.length()-1);
			 }
		 }
		return "";
	}

}
