package biometest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.frontrider.worlds.config.BiomeGenRule;
import util.ShortHands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class BiomeRuleTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Gson json =  new GsonBuilder().setPrettyPrinting().create();
        BiomeGenRule holder = new BiomeGenRule();

        String print = json.toJson(holder);

        ShortHands.log(print);
        PrintWriter file = new PrintWriter("./biomegenrule.json","utf8");

        file.write(print);
        file.close();
    }
}
