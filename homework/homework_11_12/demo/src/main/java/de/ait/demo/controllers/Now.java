package de.ait.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter

public class Now {
    int hour;
    int minute;
    int second;
    int data;

}
