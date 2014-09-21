package com.jira.ingest.controller;

import java.io.File;
import java.io.FileReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.jira.ingest.domainmodel.FileUpload;
import com.jira.ingest.service.IMasterpreparationService;
import com.jira.ingest.util.Mapper;

/**
 * @author Chee-Hong Hsia
 *
 */
public class FileUploadController extends SimpleFormController{
	private IMasterpreparationService masterpreparationService;
	
	
	public FileUploadController(){
		setCommandClass(FileUpload.class);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
 
		FileUpload fileUpload = (FileUpload)command;
		
		MultipartFile multipartFile = fileUpload.getFile();
		
		if(multipartFile!=null){
			File file = Mapper.multipartToFile(multipartFile);
			masterpreparationService.createJiraIssues(new FileReader(file));
		}
		
		return new ModelAndView("FileUploadSuccess","fileName",multipartFile.getOriginalFilename());
 
	}

	public void setMasterpreparationService(IMasterpreparationService masterpreparationService) {
		this.masterpreparationService = masterpreparationService;
	}

}
