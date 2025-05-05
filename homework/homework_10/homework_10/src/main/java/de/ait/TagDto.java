package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/*
          "confidence": 56.472225189209,
                "tag": {
                    "de": "Mann",
                    "ru": "человек"
                }
            },
 */

@NoArgsConstructor
@ToString
@Getter

public class TagDto {
    private double confidence;
    private Map<String,String> tag;
}
