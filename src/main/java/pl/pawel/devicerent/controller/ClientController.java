package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.repository.ClientRepository;

@Controller
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/addClient")
    public String addClientPage()
    {
        return "addClient";
    }


    @PostMapping("/addClient")
    public String addClient(){
        return "/";
    }

    @PostMapping
    public String deleteClient(){
        return "/";
    }

}
