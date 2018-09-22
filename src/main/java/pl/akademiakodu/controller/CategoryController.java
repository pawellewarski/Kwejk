package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.data.CategoryRepository;
import pl.akademiakodu.data.GifRepository;
import pl.akademiakodu.model.Category;
import pl.akademiakodu.model.Gif;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    GifRepository gifRepository;

    @RequestMapping("/categories")
    public String gifCategories(ModelMap modelMap) {

        List<Category> categories = CategoryRepository.getCategoryList();
        modelMap.put("categories", categories);

        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String gifCategory(@PathVariable int id,
                             ModelMap modelMap) {

        List<Gif> gifs = gifRepository.getGifsByCategory(id);
        modelMap.put("gifs", gifs);


        return "favorites";
    }

}
