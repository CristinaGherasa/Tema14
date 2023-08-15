package org.fasttrack;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fasttrack.ReadQuotesFromFile.readQuotesFromFile;

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




}