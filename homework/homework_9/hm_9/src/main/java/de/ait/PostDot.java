package de.ait;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class PostDot {
    private int id;
    private int userId;
    private String name;
    private String email;
    private String body;
}
