package br.edu.iftm.petvida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;

@SpringBootApplication
public class PetvidaApplication implements CommandLineRunner {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetvidaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       
        int nn = 12; // 
        String primeiroNome = "Ygor"; 

        // 1. Carga Base - Tutores (Seção 2)
        Tutor t1 = new Tutor(1, "Marina Alves", "34 99101-0001");
        Tutor t2 = new Tutor(2, "Carlos Prado", "34 99101-0002");
        tutorRepository.salvar(t1);
        tutorRepository.salvar(t2);

        // 2. Carga Base - Animais (Seção 2)
        Animal a2 = new Animal(2, "Mimi", "gato", 3, t1);
        Animal a3 = new Animal(3, "Thor", "cao", 1, t2);
        Animal a4 = new Animal(4, "Lila", "gato", 11, t2);
        animalRepository.salvar(a2);
        animalRepository.salvar(a3);
        animalRepository.salvar(a4);

        // 3. Semente Personalizada (Seção 3)
        int idPersonalizado = 100 + nn;
        String telefonePersonalizado = String.format("34 9%02d%02d-%02d%02d", nn, nn, nn, nn);
        
        Tutor tutorSeu = new Tutor(idPersonalizado, primeiroNome, telefonePersonalizado);
        tutorRepository.salvar(tutorSeu);

        Animal animalSeu = new Animal(idPersonalizado, "Pet_" + nn, "cao", nn, tutorSeu);
        animalRepository.salvar(animalSeu);
    }
}