import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        printWordFrequency();
    }

    public static void printWordFrequency() throws IOException {
        Map<String, Integer> counts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        counts.put(word, counts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}