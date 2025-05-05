package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter

public class ResultDto {
    private List<TagDto> tags;
}
