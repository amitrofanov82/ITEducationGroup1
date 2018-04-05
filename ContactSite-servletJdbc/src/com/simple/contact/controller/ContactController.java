package com.simple.contact.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.contact.entity.Contact;
import com.simple.contact.exception.ServiceException;
import com.simple.contact.exception.UtilException;
import com.simple.contact.service.IContactService;
import com.simple.contact.service.impl.ContactService;
import com.simple.contact.util.PaginationHelper;

public class ContactController extends HttpServlet {

	private static final long serialVersionUID = 4337315629536853275L;

	private static final int DEFAULT_CONTACTS_COUNT_ON_PAGE = 14;

	private static final String CONTACTS_PAGE_PATH = "WEB-INF/jsp/contacts.jsp";
	private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/error.jsp";

	private PaginationHelper paginator;

	{
		paginator = new PaginationHelper();
		paginator.setCountOnPage(DEFAULT_CONTACTS_COUNT_ON_PAGE);
	}

	private IContactService contactService = new ContactService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			if (null != req.getParameter("currentPageNumber")) {
				Integer currentPageNumber = Integer.valueOf(req
						.getParameter("currentPageNumber"));
				paginator.setCurrentPageNumber(currentPageNumber);
			}
			req.getSession().setAttribute("paginator", paginator);
			List<Contact> contacts = contactService.loadAll();
			req.setAttribute("contacts", paginator.getListOnPage(contacts));
			req.getRequestDispatcher(CONTACTS_PAGE_PATH).forward(req, resp);
		} catch (ServiceException | UtilException e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher(ERROR_PAGE_PATH).forward(req, resp);
		}
	}
}
