package org.ostanina.library_project.service;

import org.ostanina.library_project.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByNameAndSurnameV1(String name, String surname);

    AuthorDto getAuthorByNameAndSurnameV2(String name, String surname);

    AuthorDto getAuthorByNameAndSurnameV3(String name, String surname);
}
