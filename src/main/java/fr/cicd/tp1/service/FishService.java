package fr.cicd.tp1.service;

import fr.cicd.tp1.entity.Fish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FishService {

    private final List<Fish> fishs;
    private int id = 0;

    public FishService() {
        this.fishs = new ArrayList<>();
    }

    public List<Fish> getAllFishs(){
        return this.fishs;
    }

    public Fish createFish(Fish fish) {
        fish.setId(++this.id);
        this.fishs.add(fish);
        return fish;
    }

    public boolean deleteFishById(int id) {
        return this.fishs.removeIf(fish -> fish.getId() == id);
    }

    public Fish updateFishById(int id, Fish newFish) {
        for (Fish fish : this.fishs) {
            if (fish.getId() == id) {
                fish.setName(newFish.getName());
                fish.setSize(newFish.getSize());
                fish.setAge(newFish.getAge());
                fish.setType(newFish.getType());
                return fish;
            }
        }
        return null;
    }

}
