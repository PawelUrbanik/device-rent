package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.model.Category;
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
    public String addCategoryPage(Model model)
    {
        model.addAttribute("category", new Category());
        return "/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category)
    {
        categoryRepository.save(category);
        return "redirect:/";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(){
        return "/";
    }
}
