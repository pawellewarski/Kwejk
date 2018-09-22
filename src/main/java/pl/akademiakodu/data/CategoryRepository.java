package pl.akademiakodu.data;

import org.springframework.stereotype.Component;
import pl.akademiakodu.model.Category;
import pl.akademiakodu.model.Gif;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    public static final List<Category> All_CATEGORIES = Arrays.asList(
            new Category(1, "funny"),
            new Category(2, "sport"),
            new Category(3, "it")

    );

    public Category findById(int id) {
        for (Category value : All_CATEGORIES) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    public static List<Category> getCategoryList() {
        return All_CATEGORIES;
    }

}
