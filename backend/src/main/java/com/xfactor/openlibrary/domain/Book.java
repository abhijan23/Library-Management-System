package com.xfactor.openlibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String isbn;
    @Column
    private String publicationdate;
    @Column
    private String publisher;
    @Column
    private Long copies;
    @Column
    private String category;
    @Column
    private String genre;
    @Column
    private String subgenre;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPublicationdate() {
        return publicationdate;
    }
    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Long getCopies() {
        return copies;
    }
    public void setCopies(Long copies) {
        this.copies = copies;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getSubgenre() {
        return subgenre;
    }
    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }
}
