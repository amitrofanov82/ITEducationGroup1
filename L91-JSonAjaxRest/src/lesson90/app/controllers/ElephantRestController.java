package lesson90.app.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lesson90.app.model.Elephant;
import lesson90.app.service.ElephantManager;

@WebServlet("/elephantController")
public class ElephantRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ElephantManager elephantManager = new ElephantManager();
	private Gson gson = new GsonBuilder().create();
	

	//get Elephant
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Elephant result = elephantManager.findBestElephant();
		resp.getOutputStream().print(gson.toJson(result));
	}

	//Post new Elephant
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestContent = getBody(req);
		System.out.println(requestContent);
		Elephant elephant = gson.fromJson(requestContent, Elephant.class);
		elephantManager.updateElephant(elephant);
	}

	//Update elephant
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestContent = getBody(req);
		Elephant elephant = gson.fromJson(requestContent, Elephant.class);
		elephantManager.updateElephantsWeightWithName(elephant);
	}
	
	//Update elephant
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestContent = getBody(req);
		Elephant elephant = gson.fromJson(requestContent, Elephant.class);
		elephantManager.deleteElephantWithName(elephant);
	}
	

	private static String getBody(HttpServletRequest request) throws IOException {
	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
	
	
}
