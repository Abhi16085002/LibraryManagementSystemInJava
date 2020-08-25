package system.library.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"bookItem"})
public class Book {
	
	@Id
	private String ISBN;
	private String title;
	private  String subject;
	private String publisher;
	@Column(name = "noOfPages")
	private int noOfPages;
	@Column(name = "totalItem")
	private int toalItem;
	@Column(name = "availableItem")
	private  int availableItem;
	
	@OneToMany(targetEntity = BookItem.class ,fetch = FetchType.LAZY, mappedBy = "book")
	private Collection<BookItem> bookItem;
	
	public Collection<BookItem> getBookItem() {
		return bookItem;
	}
	public void setBookItem(Collection<BookItem> bookItem) {
		this.bookItem = bookItem;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getToalItem() {
		return toalItem;
	}
	public void setToalItem(int toalItem) {
		this.toalItem = toalItem;
	}
	public int getAvailableItem() {
		return availableItem;
	}
	public void setAvailableItem(int availableItem) {
		this.availableItem = availableItem;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", subject=" + subject + ", publisher=" + publisher
				+ ", noOfPages=" + noOfPages + ", toalItem=" + toalItem + ", availableItem=" + availableItem
				+ ", bookItem=" + bookItem + "]";
	}
	
	
	
	
}
