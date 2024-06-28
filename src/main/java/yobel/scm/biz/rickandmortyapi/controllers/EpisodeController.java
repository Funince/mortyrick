package yobel.scm.biz.rickandmortyapi.controllers;

import yobel.scm.biz.rickandmortyapi.model.Episode;
import yobel.scm.biz.rickandmortyapi.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EpisodeController {
    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/episode/{id}")
    public Episode getLocationById(@PathVariable("id") int id) {
        return rickAndMortyService.getEpisodeById(id);
    }

}