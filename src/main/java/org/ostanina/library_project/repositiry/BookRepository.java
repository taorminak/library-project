package org.ostanina.library_project.repositiry;

import org.ostanina.library_project.model.Book;
import org.ostanina.library_project.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(Genre genre);
}
