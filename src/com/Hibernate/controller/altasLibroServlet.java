package com.Hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Hibernate.model.Libro;

/**
 * Servlet implementation class altasLibroServlet
 */
@WebServlet({ "/altasLibroServlet", "/addBooks" })
public class altasLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altasLibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		Libro myBook = new Libro();
		
		//configuration for hibernate
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.Hibernate.model.Libro.class);
		cfg.configure("hibernateProperties/hibernate.cfg.xml");
		
		//create the session factory
		SessionFactory factory = cfg.buildSessionFactory();
		
		//create object session
		Session session = factory.openSession();
		
		//init transaction
		Transaction t = session.beginTransaction();
		
		
		
		String nameBook=request.getParameter("txtLibro");
		String author=request.getParameter("txtAuthor");
		String isbn=request.getParameter("txtIsbn");
		
		//add information on methods setters
		myBook.setNombreLibro(nameBook);
		myBook.setAuthor(author);
		myBook.setIsbnBook(isbn);
		
		//response to web
		response.getWriter().append("Nombre libro : "+nameBook+"\nAuthor: "+author+"\n ISBN: "+isbn);
		
		
		session.save(myBook); //persist
		//run transaction
		t.commit();
		//close the session
		session.close();
		
		System.out.println("Success!!");
		
		
	}

}
