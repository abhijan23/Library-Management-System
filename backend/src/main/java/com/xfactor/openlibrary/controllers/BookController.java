package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repositories.BookRepositories;
@RestController
@RequestMapping("books")
public class BookController {
    private BookRepositories bookRepositories;

    public BookController(BookRepositories bookRepositories){
        this.bookRepositories = bookRepositories;
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        bookRepositories.save(book);
        return book;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        if (book.getId() != null) {
            Book book2 = bookRepositories.save(book);
            return book2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepositories.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookRepositories.findAll();
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return bookRepositories.count();
    }

    @GetMapping("findById/{id}")
    public Book findById(@PathVariable Long id) {
        Optional<Book> optionalOfBook = bookRepositories.findById(id);
        if (optionalOfBook.isPresent()) {
            return optionalOfBook.get();
        }
        return null;
    }

    @GetMapping("findByTitle/{title}")
    public List<Book> findByTitle(@PathVariable String title){
        List<Book> listOfTitle = bookRepositories.findByTitle(title);
        return listOfTitle;
    }

    @GetMapping("findByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author){
        List<Book> listOfAuthor = bookRepositories.findByAuthor(author);
        return listOfAuthor;
    }

    @GetMapping("findByIsbn/{isbn}")
    public List<Book> findByisbn(@PathVariable String isbn) {
        List<Book> listOfIsbn = bookRepositories.findByIsbn(isbn);
        return listOfIsbn;
    }

    @GetMapping("/findByPublicationDate/{publicationdate}")
    public List<Book> findByPublicationdate(@PathVariable String publicationdate){
        List<Book> listOfPublicationDate = bookRepositories.findByPublicationdate(publicationdate);
        return listOfPublicationDate;
    }

    @GetMapping("findByPublisher/{publisher}")
    public List<Book> findByPublisher(@PathVariable String publisher){
        List<Book> listOfPublisher = bookRepositories.findByPublisher(publisher);
        return listOfPublisher;
    }

    @GetMapping("findByCopies/{copies}")
    public List<Book> findByCopies(@PathVariable Long copies){
        List<Book> listOfCopies = bookRepositories.findByCopies(copies);
        return listOfCopies;
    }

    @GetMapping("findByCategory/{category}")
    public List<Book> findByCategory(@PathVariable String category){
        List<Book> listOfCategory = bookRepositories.findByCategory(category);
        return listOfCategory;
    }

    @GetMapping("findByGenre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre){
        List<Book> listOfGenre = bookRepositories.findByGenre(genre);
        return listOfGenre;
    }

    @GetMapping("findBySubgenre/{subgenre}")
    public List<Book> findBySubgenre(@PathVariable String subgenre){
        List<Book> listOfSubgenre = bookRepositories.findBySubgenre(subgenre);
        return listOfSubgenre;
    }
}