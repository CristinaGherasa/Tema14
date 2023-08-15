package org.fasttrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadQuotesFromFile {

    public static List<Quote> readQuotesFromFile(String filename) {
        List<Quote> quotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("~");
                if (parts.length == 2) {
                    Quote quote = new Quote(id, parts[0], parts[1]);
                    quotes.add(quote);
                    id++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotes;
    }
}
