package system.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.library.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	public List<Book> findAllByTitle(String title);

	public List<Book> findAllByISBN(String iSBN);

	public List<Book> findAllBySubject(String subject);
	
	
	

}
