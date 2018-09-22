package pl.akademiakodu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.akademiakodu.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class GifRepository {


    public static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "michaols", true, 1),
            new Gif("ben-and-mike", "mika", false, 2),
            new Gif("book-dominos", "mem", false, 3),
            new Gif("compiler-bot", "bot", true, 1),
            new Gif("cowboy-coder", "coder", false, 2),
            new Gif("domino", "meme lord", true, 1),
            new Gif("infinite-andrew", "anrew", true, 3)
    );

    public Gif findByName(String name) {
        for (Gif value : ALL_GIFS) {
            if (name.equalsIgnoreCase(value.getName()))
                return value;
        }

        return null;
    }

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public static List<Gif> getFavoritesGifs() {
        List<Gif> favoritesGifs = new ArrayList<>();

        for (Gif value : ALL_GIFS) {
            if (value.getFavorite()) {
                favoritesGifs.add(value);
            }
        }
        return favoritesGifs;
    }

    public static List<Gif> getGifsByCategory(int id) {
        List<Gif> categoryGifs = new ArrayList<>();

        for (Gif value : ALL_GIFS) {
            if (value.getCategoryId()== id) {
                categoryGifs.add(value);
            }
        }
        return categoryGifs;
    }


}
