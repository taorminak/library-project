package org.ostanina.library_project.repositiry;

import org.ostanina.library_project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    Optional<Author> findByNameAndSurname(String name, String surname);

    @Query(nativeQuery = true, value="SELECT * FROM author WHERE name = ?1 AND surname = ?2")
    Optional<Author> findByNameAndSurnameBySql(String name, String surname);
}
