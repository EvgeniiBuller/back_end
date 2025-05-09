package de.ait.hm20250206variantlerer.controllers;


import de.ait.hm20250206variantlerer.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    private static List<Film> filmDB = new ArrayList<>(
            List.of(
                    new Film("film1",2000),
                    new Film("film2",2003)
            )
    );

    @GetMapping("/films")
    public List<Film> getFilms (){
        return filmDB;
    }

}
