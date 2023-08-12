package org.fasttrack;

import java.util.*;

public class QuoteService {
    private List<Quote> quotes;
    private Map<String, List<Quote>> quotesByAuthor;
    private List<Quote> favourites;
    private Random random;

    public QuoteService(List<Quote> quotes) {
        this.quotes = quotes;
        this.quotesByAuthor = new HashMap<>();
        this.favourites = new ArrayList<>();
        this.random = new Random();

        for (Quote quote : quotes) {
            quotesByAuthor.computeIfAbsent(quote.getAuthor(), k -> new ArrayList<>()).add(quote);
        }
    }

    public List<String> getAllQuotes() {
        List<String> allQuotes = new ArrayList<>();
        for (Quote quote : quotes) {
            allQuotes.add(quote.getQuote());
        }
        return allQuotes;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        return quotesByAuthor.getOrDefault(author, new ArrayList<>());
    }

    public List<String> getAuthors() {
        return new ArrayList<>(quotesByAuthor.keySet());
    }

    public void setFavourite(int id) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavourite(true);
                favourites.add(quote);
                break;
            }
        }
    }

    public List<Quote> getFavourites() {
        return favourites;
    }

    public String getRandomQuote() {
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex).getQuote();
    }
}
