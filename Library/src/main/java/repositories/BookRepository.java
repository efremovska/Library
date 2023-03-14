package repositories;


import jdk.jfr.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();
    List<Book> findByCategory(Category category);
    Book findBookById(Integer id);

}
