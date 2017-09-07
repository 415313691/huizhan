package com.huizhan.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


public class CreateFile {

	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;
	 
	public void create(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter printWriter = null;
    	try {
    		RearProperties reader = new RearProperties();
    		String targetPath =reader.getValue("path.properties", "FILE_PATH");
    		System.out.println("upload path =="+targetPath);
    		String fileNames = "";
    		   try { 
    			   for(int i=0;i<file.length;i++){
    				    String kzm = fileFileName[i].substring(fileFileName[i].lastIndexOf("."),fileFileName[i].length());
    		            String newImageName = String.valueOf(System.currentTimeMillis());
    		            String newFileName = newImageName+getRodom()+kzm;
    	            	File saveFile = new File(new File(targetPath),newFileName);  //在该实际路径下实例化一个文件  
    	            	printWriter = response.getWriter();
    	            	FileUtils.copyFile(file[i], saveFile);
    	            	fileNames+=newFileName+",";
    			   }
    			   System.out.println("upload success");
    			   fileNames=fileNames.substring(0,fileNames.length()-1);
    			   printWriter.write(fileNames);
                } catch (IOException e) {  
                	 System.out.println("upload failed");
                	e.printStackTrace();
                }  
		}  catch (Exception e) {
			e.printStackTrace();
		} finally{
			printWriter.flush();
			printWriter.close();
		}
	}
	
	public String getRodom(){
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		char ch=str.charAt(new Random().nextInt(str.length()));
		sb.append(ch);
		}
		return sb.toString();
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
	
 
	 
	
}
