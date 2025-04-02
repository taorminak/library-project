package org.ostanina.library_project.repositiry;

import org.ostanina.library_project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
