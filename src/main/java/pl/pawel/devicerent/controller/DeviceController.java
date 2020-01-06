package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.repository.DeviceRepository;

@Controller
public class DeviceController {

    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceController (DeviceRepository deviceRepository)
    {
        this.deviceRepository = deviceRepository;
    }


    @GetMapping("/addDevice")
    public String addDevicePage(){
        return "addDevice";
    }

    @PostMapping("/addDevice")
    public String addDevice(){
        return "/";
    }

    @PostMapping("/deleteDevice")
    public String deleteDevice(){
        return "/";
    }
}
