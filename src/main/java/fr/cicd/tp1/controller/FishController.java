package fr.cicd.tp1.controller;

import fr.cicd.tp1.dto.FishDTO;
import fr.cicd.tp1.entity.Fish;
import fr.cicd.tp1.service.FishService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api/v1/fish")
public class FishController {

    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public Iterable<Fish> getFishs() {
        return fishService.getAllFishs();
    }

    @PostMapping
    public FishDTO createFish(@RequestBody Fish fish) {
        return fishService.createFish(fish).toDto();
    }

    @PatchMapping(path = "/{id}")
    public FishDTO updateFish(@PathVariable int id, @RequestBody Fish fish) {
        final Fish modifiedFish = fishService.updateFishById(id, fish);
        if (modifiedFish == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return modifiedFish.toDto();
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteFishById(@PathVariable int id) {
        final boolean isFishDelete = fishService.deleteFishById(id);
        if (!isFishDelete) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return isFishDelete;
    }

}
