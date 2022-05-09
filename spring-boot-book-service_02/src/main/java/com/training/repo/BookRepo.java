package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
	
	// books based on title
	public List<Book> findByTitle(String title); // C
	
	public List<Book> findByTitleLike(String title);
	
	//books that are stocked less than 120
	@Query("from Book b where b.stock < :stock")
	public List<Book> getByStockLessThan(@Param("stock") Long stock);
	
	// update stock of all books that have a stock less than 120 by 50
	@Transactional
	@Modifying
	@Query("update Book as b set b.stock=b.stock + :newstock where b.stock < :oldstock")
	public int updateStock(@Param("oldstock") Long oldStock,@Param("newstock") Long newStock);
}
