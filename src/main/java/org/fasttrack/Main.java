package org.fasttrack;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Quote> quotes = readQuotesFromFile("src\\main\\java\\org\\fasttrack\\quotes.txt");
        QuoteService quoteService = new QuoteService(quotes);

        List<String> allQuotes = quoteService.getAllQuotes();
        for (String quote : allQuotes) {
            System.out.println(quote);
        }

        System.out.println(quoteService.getAuthors());
        System.out.println(quoteService.getRandomQuote());
        System.out.println(quoteService.getQuotesForAuthor("Peter Elbow"));


        int quoteIdToMarkAsFavorite = 2;
        quoteService.setFavourite(quoteIdToMarkAsFavorite);
        System.out.println("Quote marked as favorite: " + quoteIdToMarkAsFavorite);


        List<Quote> favouriteQuotes = quoteService.getFavourites();
        System.out.println("Favorite Quotes:");
        for (Quote quote : favouriteQuotes) {
            System.out.println(quote.getQuote());
        }
    }


    public static List<Quote> readQuotesFromFile(String filename) {
        List<Quote> quotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int id = 1;
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