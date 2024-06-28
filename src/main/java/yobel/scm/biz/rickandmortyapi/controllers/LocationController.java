package yobel.scm.biz.rickandmortyapi.controllers;
import yobel.scm.biz.rickandmortyapi.model.Location;
import yobel.scm.biz.rickandmortyapi.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LocationController {
        @Autowired
        private RickAndMortyService rickAndMortyService;

        @GetMapping("/location/{id}")
        public Location getLocationById(@PathVariable("id") int id) {
            return rickAndMortyService.getLocationById(id);
        }
}
