package fr.cicd.tp1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FishDTO {
    private int id;
    private String name;
    private String type;
    private int size;
    private int age;
}
