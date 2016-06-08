package com.koakh.model.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{

  List<Book> findByName(String name);
}
