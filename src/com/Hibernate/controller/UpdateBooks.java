package com.Hibernate.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateBooks
 */
@WebServlet("/UpdateBooks")
public class UpdateBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooks() {
        super();
        // TODO Auto-generated constructor stub
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
        
        //get the values on the formulary
		int idBook= Integer.parseInt(request.getParameter("txtIdLibro"));
		String nameBook=request.getParameter("txtLibro");
		String author=request.getParameter("txtAuthor");
		String isbn=request.getParameter("txtIsbn");
		
		Libro objLibro = session.get(Libro.class, idBook);
        //sett new object for update the book                            
        objLibro.setNombreLibro(nameBook);
		objLibro.setAuthor(author);
		objLibro.setIsbnBook(isbn);
                                        
        //response to web
		response.getWriter().append("Nombre libro : "+nameBook+"\nAuthor: "+author+"\n ISBN: "+isbn);
        //commit transaction
        session.getTransaction().commit();
        //cierre
        session.close();    
                                    
	}

}
