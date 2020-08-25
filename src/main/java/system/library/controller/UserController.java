package system.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import system.library.model.Book;
import system.library.model.BookItem;
import system.library.model.IssuedBook;
import system.library.model.Location;
import system.library.model.User;
import system.library.model.UserIdentityCard;
import system.library.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void doNothing() {
		System.out.println("hello world");
//		userServiceImpl.fun();
//		userServiceImpl.changeBookItemStatus(2, "hello");
		System.out.println(userServiceImpl.checkBookItemStatus(2));
		
	}
	
	
	@RequestMapping(value = "/book/title/{title}", method = RequestMethod.GET  )
//	@ResponseBody
	public List<Book> findAllBookByTitle(@PathVariable String title){
		System.out.println(title);
		List<Book> books = userServiceImpl.findAllBookByTitle(title);
//		Book boo = books.get(0);
		System.out.println(books.get(0));
//		return books.get(0);
		return books;
	}
	
	@RequestMapping(value = "/book/id/{ISBN}", method = RequestMethod.GET)
	public List<Book> findBookByISBN(@PathVariable String ISBN){
		return userServiceImpl.findBookByISBN(ISBN);
	}
	
	@RequestMapping(value = "/book/subject/{subject}", method = RequestMethod.GET)
	public List<Book> findBookBySubject(@PathVariable String subject){
		return userServiceImpl.findBookBySubject(subject);
	}
	
	@RequestMapping(value = "/location/{bookItemId}")
	public Location findBookItemLocation(@PathVariable int bookItemId) {
		Location location = userServiceImpl.findBookItemLocation(bookItemId);
		System.out.println(location);
		return location;
	}
	
	@RequestMapping(value = "/bookitem/{bookItemId}/user/{userId}", method = RequestMethod.GET)
	public BookItem checkOutBookItem(@PathVariable int bookItemId,@PathVariable int userId) {
		return userServiceImpl.checkOutBookItem(bookItemId, userId);
	}
	
	@RequestMapping(value = "/view/book/{bookItemId}", method = RequestMethod.GET)
	public BookItem viewBookItem(@PathVariable int bookItemId) {
		return userServiceImpl.viewBookItem(bookItemId);
	}
	
	@RequestMapping(value = "/check/{bookItemId}", method = RequestMethod.GET)
	public String checkBookItemStatus(@PathVariable int bookItemId) {
		return userServiceImpl.checkBookItemStatus(bookItemId);
	}
	
	@RequestMapping(value = "/issued/book/{userId}", method = RequestMethod.GET)
	public List<IssuedBook> findAllIssuedBookByUserId(@PathVariable int userId){
		List<IssuedBook> issuedBooks =  userServiceImpl.findAllIssuedBookByUserId(userId);
		List<BookItem> bookItems = new ArrayList<>();
		for(IssuedBook issuedBook : issuedBooks) {
			BookItem bookItem = issuedBook.getBookItem();
			bookItems.add(bookItem);
			System.out.println(bookItem);
		}
		return issuedBooks;
//		return bookItems;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User findUserByUserId(@PathVariable int userId) {
		return userServiceImpl.findUserByUserId(userId);
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST )
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		System.out.println(user);
		return userServiceImpl.saveUser(user);
	}
	
	
	@RequestMapping(value = "/user/card/{userId}")
	public UserIdentityCard issueUserIdentityCard(@PathVariable int userId) {
		String password ="dummy";
		return userServiceImpl.issueUserIdentityCard(userId, password);
	}
	
	@RequestMapping(value = "/bookitem/save",method = RequestMethod.POST)
	@ResponseBody
	public BookItem saveBookItem(@RequestBody BookItem bookItem) {
		System.out.println(bookItem);
		System.out.println(bookItem.getBook());
		return userServiceImpl.saveBookItem(bookItem);
	}
	
	
}

/* 
 ->  json for User
  {
    "name": "hello there",
    "dateOfBirth": "2020-08-22T14:11:54.733+00:00",
    "email": null,
    "mobileNo": 8512828343,
    "gender": null,
    "address": {
        "houseNo": 12,
        "street": "hello",
        "city": "patna",
        "state": "Bihar",
        "country": "india",
        "pinCode": 81
    }
}

-> json for bookItem

{
    "language": "hindi",
    "status": null,
    "fine": 12,
    "price": 25,
    "format": "format",
    "edition": 3,
    "book": {
        "title": "HarryPotter",
        "subject": "fiction",
        "publisher": "hello there",
        "noOfPages": 200,
        "toalItem": 5,
        "availableItem": 2,
        "isbn": "dczxxbjkbsdc"
    },
    "loaction": null
}


-> json for book

{
        "title": "HarryPotter",
        "subject": "fiction",
        "publisher": "hello there",
        "noOfPages": 200,
        "toalItem": 5,
        "availableItem": 2,
        "isbn": "dczxxbjkbsdc"
    }


 */








