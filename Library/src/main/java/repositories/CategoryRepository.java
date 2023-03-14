package repositories;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public List<Category> findAllByOrderByNameAsc();

    Category findNotebookById(Integer id);
    List<Category> findAll();

}

