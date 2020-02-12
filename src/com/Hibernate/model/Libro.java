package com.Hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_libro")
	private int idLibro;
	@Column(name="NameBook")
	private String nombreLibro;
	
	@Column(name="AuthorBook")
	private String author;
	
	@Column(name="isbnBook")
	private String isbnBook;
	
	//setters
	//public void setIdLibro(int idLibro){ this.idLibro=idLibro; }
	public void setNombreLibro(String nombreLibro){ this.nombreLibro=nombreLibro; }
	public void setAuthor(String author){ this.author=author; }
	public void setIsbnBook(String isbn){ this.isbnBook=isbn; }
	
	//getters
	//public int getIdLibro(){ return idLibro; }
	public String getNombreLibro(){ return nombreLibro; }
	public String getAuthor(){ return author; }
	public String getIsbnBook(){ return isbnBook; }
	
	
	
}
