import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.impl.NewsManagementServiceImpl;

public class SpringTest {

	public static void main(String[] args) throws ServiceException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		NewsManagementServiceImpl newsSv;
		newsSv = (NewsManagementServiceImpl) ctx.getBean("newsManagementService");
		newsSv.loadAllNews();

	}

}
