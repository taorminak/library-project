package org.ostanina.library_project.service;

import lombok.RequiredArgsConstructor;
import org.ostanina.library_project.dto.AuthorDto;
import org.ostanina.library_project.dto.BookDto;
import org.ostanina.library_project.dto.GenreDto;
import org.ostanina.library_project.model.Genre;
import org.ostanina.library_project.repositiry.BookRepository;
import org.ostanina.library_project.repositiry.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final BookRepository bookRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        GenreDto genreDto = convertEntityToDto(genre);
        return genreDto;
    }

    private GenreDto convertEntityToDto(Genre genre) {
        List<BookDto> bookDtoList = bookRepository.findByGenre(genre).stream()
                .map(book -> BookDto.builder()
                        .name(book.getName())
                        .id(book.getId())
                        .authors(book.getAuthors().stream()
                                .map(author -> AuthorDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build())
                                .toList())
                        .build())
                .toList();

        GenreDto genreDto = GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
        return genreDto;
    }
}
