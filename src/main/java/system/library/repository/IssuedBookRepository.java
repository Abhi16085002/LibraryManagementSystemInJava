package system.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import system.library.model.BookItem;
import system.library.model.IssuedBook;
import system.library.model.User;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer> {
	
	@Query(nativeQuery = true, value = "delete from librarymanagement.issued_book b where b.book_item_id = :bookItemId ")
	public void deleteByBookItemId(@Param("bookItemId") int bookItemId);

	@Query(nativeQuery = true ,value =  "Select * from librarymanagement.issued_book b where b.user_id = :userId ")
	public List<IssuedBook> findAllByUserId(@Param("userId") int userId );
	
//	@Query("select * from IssuedBook where issuedBookId = 3")
//	public List<IssuedBook> findAllByUserId( int userId );
	
	public List<IssuedBook> findAllByUser(User user);
	
	
}
