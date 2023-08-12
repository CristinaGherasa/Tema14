package org.fasttrack;
public class Quote {
    private int id;
    private String author;
    private String quote;
    private boolean favourite;

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nAuthor: " + author + "\nQuote: " + quote + "\nFavourite: " + favourite + "\n";
    }
}
