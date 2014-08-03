package com.filebrowser.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.filebrowser.filetree.TreeFileLoader;



/**
 * @author Rajkiran Veluri
 * 
 */

@RestController
@RequestMapping("/service/getFileTree/**")
public class FileBrowserController {
	
	public static final String MAPPED_PATH = "/service/getFileTree/";
	//the mapping method 
	@RequestMapping(method = RequestMethod.POST)
	public FileTreeJsonString getJsonFileTree(HttpServletRequest request) {
		String completeUrl = (String) request
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String name = extractRealPathfromUrl(completeUrl);

		return new FileTreeJsonString(name);
	}

	
	/**
     * Extracts the folder path from the POST request passed. This path will be passed to 
     * the TreeFileLoader as input;
     * The logic for handling the path depends on the underlying OS.
     *
     * @param completeUrl The url obtained from the POST request
     * @return The extracted url which will be passed to the TreeFileLoader as input.
     */
	
	public String extractRealPathfromUrl(String completeUrl) {
		// check the OS and construct the path accordingly
	 
		String name = completeUrl.substring(MAPPED_PATH.length());
		
		if (System.getProperty("os.name").toLowerCase().contains(("Windows").toLowerCase()))
		return name; //for Windows
		else
		return "/" + name; //for Linux,Unix and Mac OS
		
	
		
	}

	class FileTreeJsonString {
		/**
	     * constructor
	     * Constructs an object called FileTreeJsonString to be returned back to the
	     * UI as JSON data. This calls the TreeFileLoader methods.
	     *
	     *
	     * @param String name
	     * 
	     */
		public FileTreeJsonString(String name) {

			TreeFileLoader tfl = new TreeFileLoader();

			fileTreeJson = fileTreeJson + tfl.getJsonTreeFromStartingPath(name);
		}

		public String fileTreeJson = "";

	}
}