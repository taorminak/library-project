package org.ostanina.library_project.repositiry;

import org.ostanina.library_project.model.Book;
import org.ostanina.library_project.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findByGenre(Genre genre);

    Optional<Book> findByName(String name);

    @Query(nativeQuery = true, value="Select * from book where name = ?")
    Optional<Book> findByNameBySql(String name);
}
