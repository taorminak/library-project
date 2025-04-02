package org.ostanina.library_project.service;

import org.ostanina.library_project.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
}
