package br.com.treinaweb.twclients.controller;

import br.com.treinaweb.twclients.model.Client;
import br.com.treinaweb.twclients.repository.ClientRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("client/list.html");

        List<Client> clients = clientRepository.findAll();
        mv.addObject("clients", clients);

        return mv;
    }

    @GetMapping ("/{id}")
    public ModelAndView details(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("client/details.html");

        Client client = clientRepository.getById(id);
        mv.addObject("client", client);

        return mv;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");
        clientRepository.deleteById(id);

        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("client/register.html");
        mv.addObject("client", new Client());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView register(Client client) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");

        clientRepository.save(client);

        return mv;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("client/update.html");

        Client client = clientRepository.getOne(id);
        mv.addObject("client", client);

        return mv;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView update(Client client) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");
        clientRepository.save(client);
        return mv;
    }
}
