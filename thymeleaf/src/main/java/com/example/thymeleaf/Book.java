package com.example.thymeleaf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;



@Getter @Setter
public class Book implements Serializable {
    private String name;
    private Author author;
    private int price;
    private boolean sale;
    private double saleAmount;

    public Book(String authorName, String bookName, int price) {
        super();
        this.author = new Author(authorName);
        this.name = bookName;
        this.price = price;
    }

    public Book(String authorName, String bookName, int price, boolean sale,
                double saleAmount) {
        super();
        this.author = new Author(authorName);
        this.name = bookName;
        this.price = price;
        this.sale = sale;
        this.saleAmount = saleAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

}
