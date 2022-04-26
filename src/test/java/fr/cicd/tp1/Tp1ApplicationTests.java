package fr.cicd.tp1;

import fr.cicd.tp1.entity.Fish;
import fr.cicd.tp1.service.FishService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Tp1ApplicationTests {

    @Autowired
    private FishService fishService;

    private Fish fish = Fish.builder()
            .name("dory")
            .type("bleu")
            .age(1)
            .size(5)
            .build();
    private Fish newFish = Fish.builder()
            .id(1)
            .name("nemo")
            .type("clown")
            .age(2)
            .size(4)
            .build();

    @Test
    @Order(1)
    void getFishs() {
        Assertions.assertThat(fishService.getAllFishs()).isEmpty();
    }


    @Test
    @Order(2)
    void createFish() {
        Assertions.assertThat(fishService.createFish(fish)).isEqualTo(Fish.builder()
                .id(1)
                .name("dory")
                .type("bleu")
                .age(1)
                .size(5)
                .build());
    }

    @Test
    @Order(3)
    void updateFish() {
        Assertions.assertThat(fishService.updateFishById(1, newFish)).isEqualTo(newFish);
    }

    @Test
    @Order(4)
    void getFishs2() {
        Assertions.assertThat(fishService.getAllFishs()).isNotEmpty();
    }

    @Test
    @Order(5)
    void deleteFish() {
        Assertions.assertThat(fishService.deleteFishById(1)).isEqualTo(true);
    }

}
