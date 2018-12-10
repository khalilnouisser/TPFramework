package insat.tps.tpframework.tp_framework_dal;


import insat.tps.tpframework.tp_framework_dal.domain.Author;
import insat.tps.tpframework.tp_framework_dal.domain.Book;
import insat.tps.tpframework.tp_framework_dal.domain.Category;
import insat.tps.tpframework.tp_framework_dal.repository.AuthorRepository;
import insat.tps.tpframework.tp_framework_dal.repository.BookRepository;
import insat.tps.tpframework.tp_framework_dal.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpFrameworkDalApplication.class)
public class BookTest
{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddBook(){
        Book b = new Book();
        b.setISBN("ISBN0001");
        b.setEdition(2010);
        b.setPrice(10.2);
        b.setPriceAfterPromotion(10.0);
        b.setTitle("Book 1");
        b.setYearPublished(2010);

        Category c = new Category();
        c.setName("Category 1");
        categoryRepository.save(c);

        b.setCategory(c);

        Author author1 = new Author();
        author1.setFirstName("khalil");
        author1.setFirstName("nouisser");

        Author author2 = new Author();
        author2.setFirstName("khalil 2");
        author2.setFirstName("nouisser 2");

        authorRepository.save(author1);
        authorRepository.save(author2);

        List<Author> authors = new ArrayList<Author>();
        authors.add(author1);
        authors.add(author2);

        b.setAuthorList(authors);

        bookRepository.save(b);

        assert(b.getId()>0);
    }
}
