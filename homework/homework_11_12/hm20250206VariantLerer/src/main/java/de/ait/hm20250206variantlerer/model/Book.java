package de.ait.hm20250206variantlerer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Book {
    private Author author;
    private String title;
}
