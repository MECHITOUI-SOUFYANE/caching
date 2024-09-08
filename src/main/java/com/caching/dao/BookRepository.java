package com.caching.dao;

import com.caching.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findBookByName(String name);

    @Transactional
    @Modifying
    @Query("update Book b set b.name=:name where b.id=:id")
    int updateBook(@Param("id") Integer id , @Param("name") String name);
}
