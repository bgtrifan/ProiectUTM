package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.FiltruOrar;
import bob.home.catalogUTMnou.model.Orar;
import bob.home.catalogUTMnou.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrarController {

    private OrarRepository orarRepository;
    private FacultateRepository facultateRepository;
    private GrupaRepository grupaRepository;
    private DisciplinaRepository disciplinaRepository;
    private ProfesorRepository profesorRepository;

    public OrarController(OrarRepository orarRepository,  GrupaRepository grupaRepository, DisciplinaRepository disciplinaRepository, ProfesorRepository profesorRepository) {
        this.orarRepository = orarRepository;
//        this.facultateRepository = facultateRepository;
        this.grupaRepository = grupaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.profesorRepository = profesorRepository;
    }

    @RequestMapping("/orar")
    public String getOrar(Model model){
        model.addAttribute("orar", orarRepository.findAll());
        model.addAttribute("filtruOrar", new FiltruOrar());
        return "orar";
    }

    @GetMapping("/adorar")
    public String addOrar(Model model) {
        model.addAttribute("orar", new Orar());
        model.addAttribute("grupa", grupaRepository.findAll());
        model.addAttribute("disc", disciplinaRepository.findAll());
        model.addAttribute("prof", profesorRepository.findAll());
        return "adaugaOrar";
    }

    @GetMapping("/edorar")
    public String editOrar(@RequestParam Long id, Model model){
        model.addAttribute("edstud", orarRepository.findById(id));
        model.addAttribute("grupa", grupaRepository.findAll());
        model.addAttribute("disc", disciplinaRepository.findAll());
        model.addAttribute("prof", profesorRepository.findAll());
//        model.addAttribute("facs",facultateRepository.findAll());
        return "adaugaOrar";
    }

    @PostMapping("/saveorar")
    public String saveOrar(Orar orar){
        orarRepository.save(orar);
        return "redirect:/orar";
    }

    @GetMapping("/deleteorar")
    public String deleteOrar(@RequestParam Long id){
        orarRepository.deleteById(id);
        return  "redirect:/orar";
    }

    @PostMapping("/cautaorar")
    public ModelAndView findOrar(@ModelAttribute("filtruOrar") FiltruOrar filtruOrar, Model model){
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("orar",orarRepository.findOrarByAnScolarAndAnAndSemestru(filtruOrar.getAnScolar(),filtruOrar.getAn(),filtruOrar.getSemestru()));
        modelAndView.addObject("filtruOrar", new FiltruOrar());
        return  modelAndView;
    }
}
