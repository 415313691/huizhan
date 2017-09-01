package com.huizhan.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;


public class CreateFile {

	private File file;
	private String fileFileName;
	private String fileContentType;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public void create(){
		System.out.println("file==="+file);
		System.out.println("fileFileName==="+fileFileName);
		System.out.println("fileContentType==="+fileContentType);
    	try {
    		RearProperties reader = new RearProperties();
    		String targetPath =reader.getValue("path.properties", "FILE_PATH");
    		String newFileName = "";
    		String kzm = fileFileName.substring(fileFileName.lastIndexOf("."),fileFileName.length());
            String newImageName = String.valueOf(System.currentTimeMillis());
            newFileName = newImageName+getRodom()+kzm;
            File saveFile = new File(new File(targetPath),newFileName);  //在该实际路径下实例化一个文件  
            try {  
            	FileUtils.copyFile(file, saveFile);  
                } catch (IOException e) {  
                	e.printStackTrace();
                }  
		}  catch (Exception e) {
			e.printStackTrace();
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
	
 
	
	
}
