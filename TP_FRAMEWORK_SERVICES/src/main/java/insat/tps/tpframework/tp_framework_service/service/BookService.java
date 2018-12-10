package insat.tps.tpframework.tp_framework_service.service;

import insat.tps.tpframework.tp_framework_dal.domain.Author;
import insat.tps.tpframework.tp_framework_dal.domain.Book;
import insat.tps.tpframework.tp_framework_dal.domain.Category;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AddBookDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AuthorDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.CategoryDTO;
import insat.tps.tpframework.tp_framework_service.util.Response;


public interface BookService {
    Response addBook(AddBookDTO book);
    Response editBook(int id , AddBookDTO book);
    Response removeBook(int id);
    Response getBookById(int id);
    Response getListBooks();
    Response getListBookCategories();
    Response addBookCategory(CategoryDTO category);
    Response editBookCategory(int id , CategoryDTO category);
    Response removeBookCategory(int id);
    Response addAuthor(AuthorDTO author);
    Response editAuthor(int id , AuthorDTO author);
    Response getAuthorById(int id);
    Response removeAuthor(int id);
}
