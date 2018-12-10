package insat.tps.tpframework.tp_framework_rest.controller;

import insat.tps.tpframework.tp_framework_dal.domain.Author;
import insat.tps.tpframework.tp_framework_dal.domain.Book;
import insat.tps.tpframework.tp_framework_dal.domain.Category;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AddBookDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AuthorDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.CategoryDTO;
import insat.tps.tpframework.tp_framework_service.service.BookService;
import insat.tps.tpframework.tp_framework_service.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Response getBooks() {
        return bookService.getListBooks();
    }

    @PostMapping
    public Response addBook(@RequestBody AddBookDTO book) {
        return bookService.addBook(book);
    }

    @PutMapping("{id}")
    public Response editBook(@PathVariable int id, @RequestBody AddBookDTO book) {
        return bookService.editBook(id, book);
    }

    @DeleteMapping("{id}")
    public Response removeBook(@PathVariable int id) {
        return bookService.removeBook(id);
    }

    @GetMapping("{id}")
    public Response getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("category")
    public Response getBookCategories() {
        return bookService.getListBookCategories();
    }


    @PostMapping("category")
    public Response addBookCategory(@RequestBody CategoryDTO category) {
        return bookService.addBookCategory(category);
    }

    @PutMapping("category/{id}")
    public Response editBookCategory(@PathVariable int id, @RequestBody CategoryDTO category) {
        return bookService.editBookCategory(id, category);
    }

    @DeleteMapping("category/{id}")
    public Response removeBookCategory(@PathVariable int id) {
        return bookService.removeBookCategory(id);
    }

    @PostMapping("author")
    public Response addAuthor(@RequestBody AuthorDTO author) {
        return bookService.addAuthor(author);
    }

    @PutMapping("author/{id}")
    public Response editAuthor(@PathVariable int id, @RequestBody AuthorDTO author) {
        return bookService.editAuthor(id, author);
    }

    @DeleteMapping("author/{id}")
    public Response removeAuthor(@PathVariable int id) {
        return bookService.removeAuthor(id);
    }

    @GetMapping("author/{id}")
    public Response getAuthorById(@PathVariable int id) {
        return bookService.getAuthorById(id);
    }

}
