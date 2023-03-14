package controllers;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.CategoryRepository;

import java.util.List;
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getAllNotebooks(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category")
    public List<Category> getAllBySort() {
        return categoryRepository.findAllByOrderByNameAsc();
    }
}
