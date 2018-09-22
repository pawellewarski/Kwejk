package pl.akademiakodu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.model.gif;

@Controller
public class GifController {

    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelmap){
        gif gif = new gif("compiler-bot", "michalos", true);
        modelmap.put("gif",gif);
        return "gif-details";
    }


}
