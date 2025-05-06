package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ThingsRestController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book());
        return booksList;
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<Film> getFilms() {
        List<Film> filmsList = new ArrayList<>();
        filmsList.add(new Film("War", 1987));
        filmsList.add(new Film("Ping Pong", 2005));
        filmsList.add(new Film("Set", 1980));
        return filmsList;
    }

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public String getNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
