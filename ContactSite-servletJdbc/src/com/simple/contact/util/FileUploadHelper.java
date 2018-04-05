package com.simple.contact.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.simple.contact.exception.UtilException;

public class FileUploadHelper {

	private FileUploadHelper() {

	}

	public static String uploadFile(HttpServletRequest req, String contextPath)
			throws UtilException {
		File file;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		try {
			// Parse the request to get file items.
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = upload.parseRequest(req);

			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();
			String filePath = "";

			if (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					String fileName = fi.getName();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						filePath = contextPath
								+ fileName
										.substring(fileName.lastIndexOf("\\"));
						file = new File(filePath);
					} else {
						filePath = contextPath
								+ fileName
										.substring(fileName.lastIndexOf("\\") + 1);
						file = new File(filePath);
					}
					fi.write(file);
				}
			}
			return filePath;
		} catch (Exception e) {
			throw new UtilException(e.getMessage(), e);
		}
	}
}
