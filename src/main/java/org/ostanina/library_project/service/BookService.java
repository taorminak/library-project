package org.ostanina.library_project.service;

import org.ostanina.library_project.dto.BookDto;

public interface BookService {
    BookDto getBookByNameV1(String name);

    BookDto getBookByNameV2(String name);

    BookDto getBookByNameV3(String name);
}
