package insat.tps.tpframework.tp_framework_service.service.implementation;

import insat.tps.tpframework.tp_framework_dal.domain.Author;
import insat.tps.tpframework.tp_framework_dal.domain.Book;
import insat.tps.tpframework.tp_framework_dal.domain.Category;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AddBookDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.AuthorDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.BookDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.CategoryDTO;
import insat.tps.tpframework.tp_framework_dal.repository.AuthorRepository;
import insat.tps.tpframework.tp_framework_dal.repository.BookRepository;
import insat.tps.tpframework.tp_framework_dal.repository.CategoryRepository;
import insat.tps.tpframework.tp_framework_service.service.BookService;
import insat.tps.tpframework.tp_framework_service.util.Response;
import insat.tps.tpframework.tp_framework_service.util.ResultState;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Response addBook(AddBookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        if(!bookDTO.getAuthorList().isEmpty()){
            List<Author> listAuthors = bookDTO.getAuthorList().stream().map(x -> authorRepository.findById(x).get()).collect(Collectors.toList());
            book.setAuthorList(listAuthors);
        }
        book.setCategory(categoryRepository.findById(bookDTO.getCategoryId()).get());
        bookRepository.save(book);
        return new Response(ResultState.SUCCESS, "", book.adapt(this.modelMapper));
    }

    public Response editBook(int id, AddBookDTO bookDTO) {
        Optional<Book> b = bookRepository.findById(Long.valueOf(id));
        if (!b.isPresent())
            return new Response(ResultState.ERROR, "Book not found", null);
        Book book = modelMapper.map(bookDTO, Book.class);
        List<Author> listAuthors = bookDTO.getAuthorList().stream().map(x -> authorRepository.findById(x).get()).collect(Collectors.toList());
        book.setCategory(categoryRepository.findById(bookDTO.getCategoryId()).get());
        book.setId(Long.valueOf(id));
        bookRepository.save(book);
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response removeBook(int id) {
        Optional<Book> b = bookRepository.findById(Long.valueOf(id));
        if (!b.isPresent())
            return new Response(ResultState.ERROR, "Book not found", null);
        bookRepository.delete(b.get());
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response getBookById(int id) {
        Optional<Book> b = bookRepository.findById(Long.valueOf(id));
        if (!b.isPresent())
            return new Response(ResultState.ERROR, "Book not found", null);
        return new Response(ResultState.SUCCESS, "", b.get().adapt(this.modelMapper));
    }

    public Response getListBooks() {
        List<BookDTO> bookDTOS = new ArrayList<BookDTO>();
        Iterable<Book> books = bookRepository.findAll();
        for (Book b : books){
            if(b != null){
                bookDTOS.add(b.adapt(modelMapper));
            }
        }
        return new Response(ResultState.SUCCESS, "", bookDTOS);
    }

    @Override
    public Response getListBookCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<CategoryDTO>();
        Iterable<Category> cateogies = categoryRepository.findAll();
        for (Category b : cateogies){
            if(b != null){
                categoryDTOS.add(modelMapper.map(b, CategoryDTO.class));
            }
        }
        return new Response(ResultState.SUCCESS, "", categoryDTOS);
    }

    public Response addBookCategory(CategoryDTO categoryDTO) {
        Optional<Category> c = this.categoryRepository.findByName(categoryDTO.getName());
        if (c.isPresent()){
            return new Response(ResultState.ERROR, "Category alerady exist", null);
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return new Response(ResultState.SUCCESS, "", category);
    }

    public Response editBookCategory(int id, CategoryDTO categoryDTO) {
        Optional<Category> c = categoryRepository.findById(Long.valueOf(id));
        if (!c.isPresent())
            return new Response(ResultState.ERROR, "Book Category not found", null);
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setId(Long.valueOf(id));
        categoryRepository.save(category);
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response removeBookCategory(int id) {
        Optional<Category> c = categoryRepository.findById(Long.valueOf(id));
        if (!c.isPresent())
            return new Response(ResultState.ERROR, "Book Category not found", null);
        categoryRepository.delete(c.get());
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response addAuthor(AuthorDTO author) {
        Author authorToAdd = modelMapper.map(author, Author.class);
        authorRepository.save(authorToAdd);
        return new Response(ResultState.SUCCESS, "", authorToAdd);
    }

    public Response editAuthor(int id, AuthorDTO authorDTO) {
        Optional<Author> a = authorRepository.findById(Long.valueOf(id));
        if (!a.isPresent())
            return new Response(ResultState.ERROR, "Author not found", null);
        Author author = modelMapper.map(authorDTO, Author.class);
        author.setId(Long.valueOf(id));
        authorRepository.save(author);
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response getAuthorById(int id) {
        Optional<Author> a = authorRepository.findById(Long.valueOf(id));
        if (!a.isPresent()) {
            return new Response(ResultState.ERROR, "Author not found", null);
        }
        return new Response(ResultState.SUCCESS, "", a.get());
    }

    public Response removeAuthor(int id) {
        Optional<Author> a = authorRepository.findById(Long.valueOf(id));
        if (!a.isPresent())
            return new Response(ResultState.ERROR, "Author not found", null);
        authorRepository.delete(a.get());
        return new Response(ResultState.SUCCESS, "", null);
    }

}
