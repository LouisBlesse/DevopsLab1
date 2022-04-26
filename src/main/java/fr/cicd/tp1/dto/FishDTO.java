package fr.cicd.tp1.dto;

import lombok.Builder;

@Builder
public class FishDTO {
    private int id;
    private String name;
    private String type;
    private int size;
    private int age;
}
