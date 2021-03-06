package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.data.GifRepository;
import pl.akademiakodu.model.Gif;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {

        List<Gif> gifs = gifRepository.getAllGifs();
        modelMap.put("gifs", gifs);
        return "home";
    }


    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name,
                             ModelMap modelmap) {
//        Gif gif = new Gif("domino", "Meme Lord", true);
        Gif gif = gifRepository.findByName(name);

        modelmap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String gifFavorites(ModelMap modelMap) {

        List<Gif> gifs = gifRepository.getFavoritesGifs();
        modelMap.put("gifs", gifs);

        return "favorites";
    }

    @GetMapping("/search")
    public String gifSearch(@RequestParam String q,
                            ModelMap modelMap) {
        Gif gif = gifRepository.findByName(q);

        modelMap.put("gif", gif);
        return "gif-details";
    }

}
