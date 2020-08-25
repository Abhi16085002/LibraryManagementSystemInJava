package system.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.library.model.BookItem;
@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Integer> {
	
	@Transactional
	@Modifying
	@Query("update BookItem book set book.status = :status where book.bookItemId = :bookItemId ")
	void updateStatus(@Param("bookItemId") int bookItemId, @Param("status") String status);
	
	@Query("select status from BookItem book where book.bookItemId = :bookItemId ")
	String findStatusByBookItemId(@Param("bookItemId") int bookItemId);
	
	
	
}
