package org.ostanina.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.ostanina.library_project.dto.BookDto;
import org.ostanina.library_project.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    BookDto getBookByNameV1(@RequestParam String name) {
        return bookService.getBookByNameV1(name);
    }

    @GetMapping("/book/v2")
    BookDto getBookByNameV2(@RequestParam String name) {
        return bookService.getBookByNameV2(name);
    }

    @GetMapping("/book/v3")
    BookDto getBookByNameV3(@RequestParam String name) {
        return bookService.getBookByNameV3(name);
    }
}
