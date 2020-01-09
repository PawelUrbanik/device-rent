package pl.pawel.devicerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.devicerent.model.Client;
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
    public String addClientPage(Model model)
    {
        model.addAttribute("client", new Client());
        return "/addClient";
    }


    @PostMapping("/addClient")
    public String addClient(@ModelAttribute Client client){
        clientRepository.save(client);
        return "redirect:/";
    }

    @PostMapping
    public String deleteClient(){
        return "/";
    }

}
