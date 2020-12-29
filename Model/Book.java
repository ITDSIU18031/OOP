/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Model;

/**
 *
 * @author ASUS
 */
public class Book {
     private int ISBN;
    private String title;
    private String genre;
    private float price;
    private int year;
    private int amount;
    private int discount_id;
    private String publisher_name;

    public Book(int ISBN, String title, String genre, float price, int year, int amount, int discount_id, String publisher_name) {
        this.ISBN = ISBN;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.amount = amount;
        this.discount_id = discount_id;
        this.publisher_name = publisher_name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
}
