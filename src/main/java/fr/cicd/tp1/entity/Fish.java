package fr.cicd.tp1.entity;

import fr.cicd.tp1.dto.FishDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fish {
    private int id;
    private String name;
    private String type;
    private int size;
    private int age;

    public FishDTO toDto() {
        return FishDTO.builder()
                .id(id)
                .name(name)
                .type(type)
                .size(size)
                .age(age)
                .build();
    }
}
