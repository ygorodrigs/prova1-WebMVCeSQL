package br.edu.iftm.petvida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.petvida.repository.AnimalRepository;

@Controller // ITEM 1 Corrigido
public class ConsultaController {

    @Autowired
    private AnimalRepository repository;

    @GetMapping("consulta") // ITEM 2 (Já estava correto)
    public String consulta(Model model) {
        model.addAttribute("animal", repository.buscarPorId(2)); // ITEM 3 Corrigido ("animal" em vez de "bicho")
        return "consulta"; // ITEM 4 Corrigido ("consulta" em vez de "consulta.html")
    }
}