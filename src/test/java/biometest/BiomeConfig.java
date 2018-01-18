package biometest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.frontrider.worlds.config.BiomeConfigHolder;
import util.ShortHands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class BiomeConfig {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Gson json =  new GsonBuilder().setPrettyPrinting().create();
        BiomeConfigHolder holder = new BiomeConfigHolder();

        String print = json.toJson(holder);

        ShortHands.log(print);
        PrintWriter file = new PrintWriter("./biomeconf.json","utf8");

        file.write(print);
        file.close();
    }
}
