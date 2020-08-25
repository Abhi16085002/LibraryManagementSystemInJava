package system.library.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BookItem")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"book"})
public class BookItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookItemId")
	private int bookItemId;
	
	private String language;
	private String status;
	private double fine;
	private double price;
	private String format;
	private int edition;
	@Embedded
	private Location loaction;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ISBN")
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public Location getLoaction() {
		return loaction;
	}
	public void setLoaction(Location loaction) {
		this.loaction = loaction;
	}
	public void setBookItemId(int bookItemId) {
		this.bookItemId = bookItemId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBookItemId() {
		return bookItemId;
	}
	@Override
	public String toString() {
		return "BookItem [bookItemId=" + bookItemId + ", language=" + language + ", status=" + status + ", fine=" + fine
				+ ", price=" + price + ", format=" + format + ", edition=" + edition + ", loaction=" + loaction + "]";
	}
	
	

}
