package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.repository.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository repository)
    {
        this.categoryRepository = repository;
    }


    @GetMapping("/addCategory")
    public String addCategoryPage()
    {
        return "/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory()
    {
        return "redirect:/";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(){
        return "/";
    }
}
