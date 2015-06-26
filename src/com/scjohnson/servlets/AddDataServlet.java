package com.scjohnson.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scjohnson.services.AddDataService;
import com.scjohnson.services.LoginService;

/**
 * Servlet implementation class AddDataServlet
 */
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     
    public AddDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    
    /*
    Integer cc = Integer.parseInt(c);
    Integer dd = Integer.parseInt(d);
    Integer ee = Integer.parseInt(e);
    Integer ff = Integer.parseInt(f);
    Integer gg = Integer.parseInt(g);
    Integer hh = Integer.parseInt(h);
    Integer ii = Integer.parseInt(i);
    */
    
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
