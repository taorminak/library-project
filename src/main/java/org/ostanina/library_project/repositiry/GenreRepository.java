package org.ostanina.library_project.repositiry;

import org.ostanina.library_project.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
