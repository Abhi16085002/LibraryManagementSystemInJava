package system.library.service;

import java.util.List;

import system.library.model.Book;
import system.library.model.BookItem;
import system.library.model.IssuedBook;
import system.library.model.Location;
import system.library.model.User;
import system.library.model.UserIdentityCard;

public interface UserService {
	
	public List<Book> findAllBookByTitle(String title);
	public List<Book> findBookByISBN(String ISBN);
	public List<Book> findBookBySubject(String subject);
//	public List<BookItem> findBookByAuthor(String author);	
	
	public Location findBookItemLocation(int bookItemId);
	public BookItem checkOutBookItem(int bookItemId, int userId);
	public BookItem viewBookItem(int bookItemId);
	public String checkBookItemStatus(int bookItemId);
	public IssuedBook issueBookItem(int bookItemId,int userId);
	public void returnBookItem(int bookItemId,int userid);
	public BookItem saveBookItem(BookItem bookItem);
	public BookItem updateBookItem( BookItem bookItem);
	public void changeBookItemStatus(int bookItemId,String status);
	
	public List<IssuedBook> findAllIssuedBookByUserId(int userId);
	public User findUserByUserId(int userId);
	public void cancelMembership(int userId);
	public List<IssuedBook> findAllIssuedBook();
	public void fun();
	public void fun2();
	
	
	// Librarian
	public User saveUser(User user);
	public User updateUser(User user);
	public UserIdentityCard issueUserIdentityCard(int userId,String password);
	public void payFine(int userId,double fineAmount);
	public void addBalance(int userId,double amount);
	
}
