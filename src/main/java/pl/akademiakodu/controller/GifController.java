package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.data.GifRepository;
import pl.akademiakodu.model.Gif;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){

        List<Gif> gifs = gifRepository.getAllGifs();
        modelMap.put("gifs",gifs);
        return "home";
    }


    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name,
                             ModelMap modelmap){
//        Gif gif = new Gif("domino", "Meme Lord", true);
        Gif gif = gifRepository.findByName(name);

        modelmap.put("gif",gif);
        return "gif-details";
    }


}
