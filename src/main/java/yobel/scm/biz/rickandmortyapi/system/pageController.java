/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yobel.scm.biz.rickandmortyapi.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import yobel.scm.biz.rickandmortyapi.exceptions.ResourceNotFoundException;
import yobel.scm.biz.rickandmortyapi.model.*;
import yobel.scm.biz.rickandmortyapi.model.Character;
import yobel.scm.biz.rickandmortyapi.service.RickAndMortyService;


@Controller
class pageController {

	@Autowired
	private RickAndMortyService rickAndMortyService;

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/character/find")
	public String showSearchForm() {
		return "character/findCharacter";
	}

	@GetMapping("/episode/find")
	public String showSearchFormepisode() {
		return "episode/findEpisode";
	}

	@GetMapping("/location/find")
	public String showSearchFormlocation() {
		return "location/findLocation";
	}

	@GetMapping("/character/find/results")
	public String search(@RequestParam String name, @RequestParam(required = false, defaultValue = "1") int page, Model model) {
		try {
		CharactersResponse response = rickAndMortyService.getCharactersByNameAndPage(name, page);
		model.addAttribute("characters", response.getResults());
		model.addAttribute("info", response.getInfo());
		model.addAttribute("name", name); // Para mantener el nombre en el formulario
		return "character/characterList";
		} catch (HttpClientErrorException.NotFound ex) {
			throw new ResourceNotFoundException("Character not found: " + name);
		}
	}

	@GetMapping("/detail")
	public String detail(@RequestParam int id, Model model) {
		Character character = rickAndMortyService.getCharacterById(id);
		model.addAttribute("character", character);
		return "character/characterDetail";
	}

	@GetMapping("/episode")
	public String episode(@RequestParam String id, Model model) {
		int episodeId = Integer.parseInt(id);
		Episode episode = rickAndMortyService.getEpisodeById(episodeId);
		model.addAttribute("episode", episode);
		return "episode/episodeDetail";
	}

	@GetMapping("/episode/find/results")
	public String searchEpisodes(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "episode", required = false) String episode,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model) {
		try {
		episodeResponse response = rickAndMortyService.getEpisodes(name, episode , page);
		if (response.getResults().isEmpty()) {
			model.addAttribute("message", "No episodes found for the search criteria.");

		} else {
			model.addAttribute("episodes", response.getResults());
			model.addAttribute("info", response.getInfo());
			model.addAttribute("name", name); // Para mantener el nombre en el formulario
		}
		return "episode/episodeList";
		} catch (HttpClientErrorException.NotFound ex) {
			throw new ResourceNotFoundException("Episode not found: " + name);
		}
	}

	@GetMapping("/location/find/results")
	public String searchLocations(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "dimension", required = false) String dimension,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model) {
		try {
			locationResponse response = rickAndMortyService.getLocations(name, type,dimension, page);
			if (response.getResults().isEmpty()) {
				model.addAttribute("message", "No episodes found for the search criteria.");

			} else {
				model.addAttribute("locations", response.getResults());
				model.addAttribute("info", response.getInfo());
				model.addAttribute("name", name); // Para mantener el nombre en el formulario
			}
			return "location/locationList";
		} catch (HttpClientErrorException.NotFound ex) {
			throw new ResourceNotFoundException("Episode not found: " + name);
		}
	}

	@GetMapping("/location")
	public String location(@RequestParam String id, Model model) {
		int locationId = Integer.parseInt(id);
		Location location = rickAndMortyService.getLocationById(locationId);
		model.addAttribute("location", location);
		return "location/locationDetail";
	}
}

