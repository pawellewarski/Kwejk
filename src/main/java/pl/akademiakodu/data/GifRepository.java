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
            new Gif("android-explosion", "michaols", true ),
            new Gif("ben-and-mike", "mika", false ),
            new Gif("book-dominos", "mem", false ),
            new Gif("compiler-bot", "bot", true ),
            new Gif("cowboy-coder", "coder", false ),
            new Gif("domino", "meme lord", true ),
            new Gif("infinite-andrew", "anrew", true )
    );

    public Gif findByName(String name){
        for (Gif value : ALL_GIFS) {
            if( name.equalsIgnoreCase(value.getName()))
                    return value;
        }

        return null;
    }

    public static List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public static List<Gif> getFavoritiesGifs(){
        List<Gif> favoritiesGifs = new ArrayList<>();

        for (Gif value: ALL_GIFS) {
            if (value.getFavorite()){
                favoritiesGifs.add(value);
            }
        }

        return favoritiesGifs;
    }




}
