package yobel.scm.biz.rickandmortyapi.controllers;

import yobel.scm.biz.rickandmortyapi.model.Character;
import yobel.scm.biz.rickandmortyapi.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CharacterController {
    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/character/{id}")
    public Character getCharacterById(@PathVariable("id") int id) {
        return rickAndMortyService.getCharacterById(id);
    }

}
