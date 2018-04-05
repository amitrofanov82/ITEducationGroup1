package com.simple.contact.util;

import java.util.Collections;
import java.util.List;

import com.simple.contact.exception.UtilException;

public class PaginationHelper {

	private static final int DEFAULT_CURRENT_PAGE_NUMBER = 1;

	private int countOnPage;
	private int pagesCount;
	private int currentPageNumber;

	public PaginationHelper() {
		currentPageNumber = DEFAULT_CURRENT_PAGE_NUMBER;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		if (currentPageNumber < 1) {
			throw new UtilException("Invalid currentPage value ");
		}
		this.currentPageNumber = currentPageNumber;
	}

	public int getCountOnPage() {
		return countOnPage;
	}

	public void setCountOnPage(int countOnPage) {
		if (countOnPage < 0) {
			throw new UtilException("Invalid countOnPage value ");
		}
		this.countOnPage = countOnPage;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		if (pagesCount < 0) {
			throw new UtilException("Invalid pagesCount value ");
		}
		this.pagesCount = pagesCount;
	}

	public <T> List<T> getListOnPage(List<T> fullList) {
		int size = fullList.size();
		pagesCount = (size + (countOnPage - 1)) / countOnPage;
		int startNumber = (currentPageNumber - 1) * countOnPage;
		int lastNumber = startNumber + countOnPage;
		currentPageNumber = DEFAULT_CURRENT_PAGE_NUMBER;

		if (lastNumber > size) {
			if (startNumber > size) {
				return Collections.emptyList();
			}
			return fullList.subList(startNumber, size);
		}
		return fullList.subList(startNumber, lastNumber);
	}
}
