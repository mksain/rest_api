package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list=new ArrayList<>();
//	
//	static
//	{
//		list.add(new Book(12,"JAVA Compiling","James Gosling"));
//		list.add(new Book(15,"Python Language","denic richi"));
//		list.add(new Book(18,"C++ object oriented prog","kk kharbanda"));
//	}
	
	public List<Book> getAllBooks()
	{
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book=null;
		
//		for (Book boo : list) {
//			if(boo.getId()==id)
//			{
//				book=boo;
//			}
	//}
		book=this.bookRepository.findById(id);
		
		
		return book;
	}
	
	public Book addBook(Book b)
	{
		
		//list.add(b);
		
		Book result=bookRepository.save(b);
		return result;
	}

//	public List<Book> deleteBook(int bookId) 
//	{
//		List<Book> list2=new ArrayList<>();
//	 
//		for (Book book : list) {
//			if(book.getId()!=bookId)
//			{
//				list2=list;
//			}
//			else
//			{
//				list.remove(book);
//			}
//		}
//		return list2;
//	}
	
	public void deleteBook(int bid)
	{
//		list=list.stream().filter(book ->{
//			if(book.getId()!=bid)
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		
		bookRepository.deleteById(bid);
	}
	
	//Update Book
	
	public Book updateBook(Book book,int bookId)
	{
//		list =list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//				
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);

	return bookRepository.save(book);
	
	}
	
	
}
