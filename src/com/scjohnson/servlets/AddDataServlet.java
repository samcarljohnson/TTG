package com.scjohnson.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scjohnson.services.AddDataService;
import com.scjohnson.services.LoginService;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class AddDataServlet
 */
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AddDataServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   log.info("Logger is working inside doGet!!!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  //PropertyConfigurator.configure("properties/log4j.properties");
	  
	  log.info("Logger is working inside doPost!!!");
	  //log.log(Level.TRACE, "Logger is working inside doPost!!!");
	  AddDataService data = new AddDataService();
    String a = request.getParameter("bubble_name");
    String b = request.getParameter("creator");
    String c = request.getParameter("bubble_num_moments");
    String d = request.getParameter("widget_nbu_views");
    String e = request.getParameter("total_video_views");
    String f = request.getParameter("visits");
    String g = request.getParameter("views_per_visit");
    String h = request.getParameter("average_watch_time");
    String i = request.getParameter("percentage_mobile");
    
    int cc = Integer.parseInt(c);
    int dd = Integer.parseInt(d);
    int ee = Integer.parseInt(e);
    int ff = Integer.parseInt(f);
    int gg = Integer.parseInt(g);
    int hh = Integer.parseInt(h);
    int ii = Integer.parseInt(i);
      
    
    PrintWriter out = response.getWriter();
    
    Boolean unique = data.uniqueStr(a);
    if(unique) { 
      data.addData(a,b,cc,dd,ee,ff,gg,hh,ii);
      out.write("Bubble \""+a+"\" was added to the database.");
    } else {
      out.write("Sorry, a bubble with that name already exists. Choose another name.");
    }
	}

}
