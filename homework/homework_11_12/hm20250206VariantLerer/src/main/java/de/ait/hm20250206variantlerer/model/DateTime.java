package de.ait.hm20250206variantlerer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
}
