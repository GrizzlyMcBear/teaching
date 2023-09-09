package teaching.java.classes.HashMap;

import teaching.java.classes.HashMap.helpers.keys.Animal;
import teaching.java.classes.HashMap.helpers.keys.Cat;
import teaching.java.classes.HashMap.helpers.keys.Dog;
import teaching.java.classes.HashMap.helpers.keys.Hamster;
import teaching.java.classes.HashMap.helpers.values.Drums;
import teaching.java.classes.HashMap.helpers.values.Guitar;
import teaching.java.classes.HashMap.helpers.values.Instrument;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Motivation_01 {
    public static void run() {
//        createAndFillSimpleIntegerHashMap();
//        puttingDuplicateKeys();
//        moviesToGenresHashMap();
        animalsToInstrumentsMap();
    }
    private static void createAndFillSimpleIntegerHashMap() {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        integerHashMap.put(1, 1);
        integerHashMap.put(2, 2);
        integerHashMap.put(3, 1);

        System.out.print(integerHashMap.toString());
    }
    private static void puttingDuplicateKeys() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(1, 1);
        hashMap.put(1, 2);
        System.out.println(hashMap.toString());

        hashMap.replace(2, 3);
        hashMap.replace(1, 13);
        System.out.println(hashMap.toString());

        hashMap.replace(1, 13, 14);
        hashMap.replace(1, 15, 200);
        System.out.println(hashMap.toString());
    }
    private static void moviesToGenresHashMap() {
        HashMap<String, List<String>> moviesToGenresMap = new HashMap<String, List<String>>();

        moviesToGenresMap.put("The Shawshank Redemption", Arrays.asList("Drama"));
        moviesToGenresMap.put("The Godfather", Arrays.asList("Crime", "Drama"));
        moviesToGenresMap.put("The Dark Knight", Arrays.asList("Action", "Crime", "Drama"));

        moviesToGenresMap.forEach((key, value) -> {
            String currData = String.format("Movie name (Key): %-25s | Movie Genre(s) (Value): %s", key, value.toString());
            System.out.println(currData);
        });
    }
    private static void animalsToInstrumentsMap() {
        HashMap<Animal, Instrument> animalsToInstrumentsMap = new HashMap<>(10);

        animalsToInstrumentsMap.put(new Dog("Spot", 7, "Golden"),
                new Guitar("Oak", 7));
        animalsToInstrumentsMap.put(new Cat("Gini", 8, 999),
                new Drums("Scarlet", true));
        animalsToInstrumentsMap.put(new Dog("Spot", 7, "Golden"),
                new Guitar("Blue", 7));

        for (Animal animal : animalsToInstrumentsMap.keySet()) {
            String currLine = String.format("(Key: %-55s \t (%s)\t|\t Value: %-60s)", animal.toString(), animal.hashCode(), animalsToInstrumentsMap.get(animal));
            System.out.println(currLine);
        }
    }
}
