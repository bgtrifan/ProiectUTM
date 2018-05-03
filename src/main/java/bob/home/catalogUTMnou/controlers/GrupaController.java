package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Disciplina;
import bob.home.catalogUTMnou.model.Grupa;
import bob.home.catalogUTMnou.repositories.DisciplinaRepository;
import bob.home.catalogUTMnou.repositories.FacultateRepository;
import bob.home.catalogUTMnou.repositories.GrupaRepository;
import bob.home.catalogUTMnou.repositories.ProfesorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GrupaController {

    private GrupaRepository grupaRepository;
    private FacultateRepository facultateRepository;
    private ProfesorRepository profesorRepository;
    private DisciplinaRepository disciplinaRepository;

    public GrupaController(GrupaRepository grupaRepository, FacultateRepository facultateRepository, ProfesorRepository profesorRepository) {
        this.grupaRepository = grupaRepository;
        this.facultateRepository = facultateRepository;
        this.profesorRepository = profesorRepository;
    }

    @RequestMapping("/grupa")
    public String getGrupa(Model model){
        model.addAttribute("grupa", grupaRepository.findAll());
        return "grupa";
    }

    @GetMapping("/adgrupa")
    public String addStudent(Model model) {
        model.addAttribute("grupa", new Grupa());
        model.addAttribute("facs", facultateRepository.findAll());
        return "adaugaGrupa";
    }

    @PostMapping("/savegrupa")
    public String save(Grupa grupa) {
        grupaRepository.save(grupa);
        return "redirect:/grupa";
    }

    @GetMapping("/addiscgrp")
    public String addDisciplinaGrupa(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        model.addAttribute("facs", facultateRepository.findAll());
        model.addAttribute("grupe", grupaRepository.findAll());
        model.addAttribute("profesori" , profesorRepository.findAll());
        return "adaugaGrupaDisc";
    }

    @PostMapping("/savegrupadisc")
    public String saveGrupaDisc(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
        return "redirect:/grupa";
    }

    @GetMapping("/deletegrupa")
    public String delete(@RequestParam Long id){
        grupaRepository.deleteById(id);
        return  "redirect:/grupa";
    }

    @GetMapping("/edgrupa")
    public String editStudent(@RequestParam Long id, Model model){
        model.addAttribute("grupa", grupaRepository.findById(id));
        return "adaugaGrupa";
    }
}
