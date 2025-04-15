package org.ostanina.library_project.service;

import lombok.RequiredArgsConstructor;
import org.ostanina.library_project.dto.AuthorDto;
import org.ostanina.library_project.dto.BookDto;
import org.ostanina.library_project.model.Author;
import org.ostanina.library_project.repositiry.AuthorRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto getAuthorByNameAndSurnameV1(String name, String surname) {
        Author author = authorRepository.findByNameAndSurname(name, surname).orElseThrow();
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameAndSurnameV2(String name, String surname) {
        Author author = authorRepository.findByNameAndSurnameBySql(name, surname).orElseThrow();
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameAndSurnameV3(String name, String surname) {
        Specification<Author> specification = (root, query, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("name"), name),
                        criteriaBuilder.equal(root.get("surname"), surname)
                );

        Author author = authorRepository.findOne(specification).orElseThrow();
        return convertEntityToDto(author);
    }

    private AuthorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList = author.getBooks().stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build())
                .toList();

        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .books(bookDtoList)
                .build();
        return authorDto;
    }
}
