package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Filtru;
import bob.home.catalogUTMnou.model.Profesor;
import bob.home.catalogUTMnou.repositories.ProfesorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfesorController {

    private ProfesorRepository profesorRepository;

    public ProfesorController(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }

    @RequestMapping("/profesor")
    public String getProfesor(Model model){
        model.addAttribute("profesor", profesorRepository.findAll());
        return "profesor";
    }

    @GetMapping("/adprof")
    public String add(Model model) {
        model.addAttribute("adprof", new Profesor());
        return "adaugaProf";
    }

    @GetMapping("/edprof")
    public String edit(@RequestParam Long id, Model model){
        model.addAttribute("adprof", profesorRepository.findById(id));
        return "adaugaProf";
    }

    @PostMapping("/saveprof")
    public String save(Profesor profesor){
        profesorRepository.save(profesor);
        return "redirect:/profesor";
    }

    @GetMapping("/deleteprof")
    public String delete(@RequestParam Long id){
        profesorRepository.deleteById(id);
        return  "redirect:/profesor";
    }

    @PostMapping("/cautaprof")
    public ModelAndView findProf(@ModelAttribute("filtru") Filtru filtru, Model model){
        ModelAndView modelAndView = new ModelAndView("profesor");
        modelAndView.addObject("profesor",profesorRepository.findProfesorByCnp(filtru.getCnp()));
        modelAndView.addObject("filtru", new Filtru());
        return  modelAndView;
    }
}
