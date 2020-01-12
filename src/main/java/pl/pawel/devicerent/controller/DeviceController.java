package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.model.Category;
import pl.pawel.devicerent.model.Device;
import pl.pawel.devicerent.repository.CategoryRepository;
import pl.pawel.devicerent.repository.DeviceRepository;

import java.util.List;

@Controller
public class DeviceController {

    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceController (DeviceRepository deviceRepository, CategoryRepository categoryRepository)
    {
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/addDevice")
    public String addDevicePage(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("device", new Device());
//        model.addAttribute("categoryFromInput", new Category());
        return "/addDevice";
    }

    @PostMapping("/addDevice")
    public String addDevice(Model model, @ModelAttribute(name = "device") Device device, BindingResult bindingResult){
        if (bindingResult.hasErrors())
        {
            System.out.println("errors");
        }else {
            deviceRepository.save(device);
        }
        return "/home";
    }

    @PostMapping("/deleteDevice")
    public String deleteDevice(){
        return "/";
    }
}
