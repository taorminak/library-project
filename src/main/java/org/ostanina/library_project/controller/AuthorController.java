package org.ostanina.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.ostanina.library_project.dto.AuthorDto;
import org.ostanina.library_project.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByNameAndSurnameV1(@RequestParam String name, @RequestParam String surname) {
        return authorService.getAuthorByNameAndSurnameV1(name, surname);
    }

    @GetMapping("/author/v2")
    AuthorDto getAuthorByNameAndSurnameV2(@RequestParam String name, @RequestParam String surname) {
        return authorService.getAuthorByNameAndSurnameV2(name, surname);
    }

    @GetMapping("/author/v3")
    AuthorDto getAuthorByNameAndSurnameV3(@RequestParam String name, @RequestParam String surname) {
        return authorService.getAuthorByNameAndSurnameV3(name, surname);
    }
}
