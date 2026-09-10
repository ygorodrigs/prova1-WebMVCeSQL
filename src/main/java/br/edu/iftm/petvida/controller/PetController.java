package br.edu.iftm.petvida.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;

@Controller
public class PetController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping("/ficha_12")
    public String ficha(Model model) {
        int nn = 12; 
        int idPersonalizado = 100 + nn;
        
        Animal animal = animalRepository.buscarPorId(idPersonalizado);
        model.addAttribute("animal", animal);
        
        return "ficha";
    }

    @GetMapping("/tutor_12")
    public String tutor(Model model) {
        int nn = 12; 
        int idPersonalizado = 100 + nn;

        // Como não há busca direta por id do tutor no DER/repositório além dos salvamentos,
        // recuperamos o tutor através do animal ou por ID se você preferir.
        Animal animal = animalRepository.buscarPorId(idPersonalizado);
        Tutor tutor = animal.getTutor();
        int qtdAnimais = tutorRepository.contarAnimaisDoTutor(tutor.getId());

        model.addAttribute("tutor", tutor);
        model.addAttribute("qtdAnimais", qtdAnimais);

        return "tutor";
    }

    // Substitua '34' pelo seu NN
    @GetMapping("/resumo_12")
    public String resumo(Model model) {
        int totalAnimais = animalRepository.contarAnimais();
        double mediaIdade = animalRepository.mediaIdade();
        String animalMaisVelho = animalRepository.animalMaisVelho();

        // Formatação das 2 casas decimais e da data/hora OBRIGATORIAMENTE no Java (devido às restrições da view)
        String mediaIdadeFormatada = String.format(Locale.US, "%.2f", mediaIdade);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraAtual = LocalDateTime.now().format(formatter);

        model.addAttribute("totalAnimais", totalAnimais);
        model.addAttribute("mediaIdade", mediaIdadeFormatada);
        model.addAttribute("animalMaisVelho", animalMaisVelho);
        model.addAttribute("dataHora", dataHoraAtual);

        return "resumo";
    }
}