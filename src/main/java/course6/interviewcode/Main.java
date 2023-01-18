package course6.interviewcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> titles = Stream.generate(() ->
                (char) new Random().nextInt('a', 'z') + "")
                .limit(28)
                .collect(Collectors.toList());
        System.out.println(titles);

        List<List<String>> shelves = putBooksOnShelves(titles);
        shelves.forEach(System.out::println);
    }

    public static List<List<String>> putBooksOnShelves(List<String> titles) {
        titles.sort(Comparator.naturalOrder());
        int shelfSize = (int) Math.round((double) titles.size() / 5);
        List<List<String>> shelves = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * shelfSize;
            int endIndex = (i + 1) * shelfSize;
            List<String> shelf;
            if (i != 4) {
                shelf = new ArrayList<>(titles.subList(startIndex, endIndex));
            } else {
                shelf = new ArrayList<>(titles.subList(startIndex, titles.size()));
            }
            shelves.add(shelf);
        }
        return shelves;
    }
}
