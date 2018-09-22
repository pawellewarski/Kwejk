package pl.akademiakodu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.model.gif;

@Controller
public class GifController {

    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        gif gif = new gif("domino","A",true);
        modelMap.put("gif", gif);
        return "gif-details";
    }


}
