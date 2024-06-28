package yobel.scm.biz.rickandmortyapi.client;

import org.springframework.web.bind.annotation.RequestParam;
import yobel.scm.biz.rickandmortyapi.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import yobel.scm.biz.rickandmortyapi.model.Character;

@FeignClient(name = "rickAndMortyClient", url = "https://rickandmortyapi.com/api")
public interface RickAndMortyClient {
    @GetMapping("/character/{id}")
    Character getCharacterById(@PathVariable("id") int id);

    @GetMapping("/location/{id}")
    Location getLocationById(@PathVariable("id") int id);

    @GetMapping("/episode/{id}")
    Episode getEpisodeById(@PathVariable("id") int id);

    @GetMapping("/episode")
    episodeResponse searchEpisodes(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "episode", required = false) String episode,
            @RequestParam(value = "page", required = false) int page  );

    @GetMapping("/character")
    CharactersResponse getCharactersByNameAndPage(@RequestParam("name") String name, @RequestParam("page") int page);

    @GetMapping("/location")
    locationResponse searchLocations(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "dimension", required = false) String dimension,
            @RequestParam(value = "page", required = false) int page );

}
