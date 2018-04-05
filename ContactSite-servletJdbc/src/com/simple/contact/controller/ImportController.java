package com.simple.contact.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.contact.entity.Contact;
import com.simple.contact.exception.ServiceException;
import com.simple.contact.exception.UtilException;
import com.simple.contact.service.IContactService;
import com.simple.contact.service.impl.ContactService;
import com.simple.contact.util.CsvImporter;
import com.simple.contact.util.FileUploadHelper;

@MultipartConfig
public class ImportController extends HttpServlet {

	private static final long serialVersionUID = -5975090499104015982L;

	private static final String IMPORT_PAGE_PATH = "WEB-INF/jsp/import.jsp";
	private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/error.jsp";
	private static final String UPLOAD_SUCCESS_MESSAGE = "File loaded successfully";
	private static final String UPLOAD_FAILURE_MESSAGE = "Can't load file";

	private IContactService contactServise = new ContactService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(IMPORT_PAGE_PATH).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String filePath = FileUploadHelper.uploadFile(req,
					getServletContext().getRealPath("") + File.separator);
			List<Contact> contacts = CsvImporter.importCsv(filePath);
			contactServise.saveOrUpdate(contacts);
			req.setAttribute("uploadMessage", UPLOAD_SUCCESS_MESSAGE);
			req.getRequestDispatcher(IMPORT_PAGE_PATH).forward(req, resp);
		} catch (UtilException e) {
			req.setAttribute("uploadMessage", UPLOAD_FAILURE_MESSAGE);
			req.getRequestDispatcher(IMPORT_PAGE_PATH).forward(req, resp);
		} catch (ServiceException e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher(ERROR_PAGE_PATH).forward(req, resp);
		}
	}

}
