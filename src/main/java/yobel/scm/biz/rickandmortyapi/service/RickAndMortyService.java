package yobel.scm.biz.rickandmortyapi.service;
import yobel.scm.biz.rickandmortyapi.client.RickAndMortyClient;
import yobel.scm.biz.rickandmortyapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yobel.scm.biz.rickandmortyapi.model.Character;


@Service
public class RickAndMortyService {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    public Character getCharacterById(int id) {

        return rickAndMortyClient.getCharacterById(id);
    }

    public Location getLocationById(int id) {
        return rickAndMortyClient.getLocationById(id);
    }

    public Episode getEpisodeById(int id) {
        return rickAndMortyClient.getEpisodeById(id);
    }

    public CharactersResponse getCharactersByNameAndPage(String name, int page){
        return rickAndMortyClient.getCharactersByNameAndPage(name, page);
    }

    public episodeResponse getEpisodes(String name, String episode, int page) {
        return rickAndMortyClient.searchEpisodes(name, episode,page);
    }
    public locationResponse getLocations(String name, String type , String dimension, int page){
        return  rickAndMortyClient.searchLocations(name, type,dimension, page);
    }
}
