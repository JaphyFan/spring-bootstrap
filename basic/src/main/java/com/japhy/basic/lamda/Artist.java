package com.japhy.basic.lamda;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Japhy
 * @since 2020/4/25 15:39
 */
@Data
@Builder
@AllArgsConstructor
public class Artist {

    private String name;

    private List<Musician> musicianList;

}
