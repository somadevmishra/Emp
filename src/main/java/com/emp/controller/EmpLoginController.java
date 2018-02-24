package com.emp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmpLoginController {
	
	private static Logger logger= LogManager.getLogger(EmpLoginController.class);
	private static final String FOLDERPATH="C:/Users/somadev mishra/Documents/testUpload";

	@RequestMapping(path="/succesful", method=RequestMethod.POST)
	public String successfulLogin(){
		return "successful";
	}
	@RequestMapping(path="/login")
	public String login(){
		return "login";
	}
	@RequestMapping(path="/upload",method= RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile mfile){
		try {
			String folderName=createFolderName();
			File folder=new File(FOLDERPATH+File.separator+folderName);
			folder.mkdir();
			mfile.transferTo(new File(folder.getPath(),mfile.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			logger.error(e.getMessage());
		}
		return "uploadsuccessful";
	}
	
	private String createFolderName(){
		Date now= new Date();
		return Long.toString(now.getTime());
	}
}
