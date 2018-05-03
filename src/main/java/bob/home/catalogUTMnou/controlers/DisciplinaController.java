package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Disciplina;
import bob.home.catalogUTMnou.model.FiltruDisciplina;
import bob.home.catalogUTMnou.repositories.DisciplinaRepository;
import bob.home.catalogUTMnou.repositories.FacultateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisciplinaController {

    private DisciplinaRepository disciplinaRepository;
    private FacultateRepository facultateRepository;

    public DisciplinaController(DisciplinaRepository disciplinaRepository, FacultateRepository facultateRepository){
        this.disciplinaRepository = disciplinaRepository;
        this.facultateRepository = facultateRepository;
    }

    @RequestMapping("/disciplina")
    public String getDisciplina(Model model){
        model.addAttribute("discipline", disciplinaRepository.findAll());
        model.addAttribute("facs", facultateRepository.findAll());
        model.addAttribute("filtruDisciplina", new FiltruDisciplina());

        return "disciplina";
    }

    @GetMapping("/addisc")
    public String addDisciplina(Model model) {
//        model.addAttribute("disciplina", new Disciplina(null,null,null,null,null,null));
        model.addAttribute("disciplina", new Disciplina());
        model.addAttribute("facs", facultateRepository.findAll());
        return "adaugaDisciplina";
    }



    @PostMapping("/savedisciplina")
    public String saveDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplina";
    }

    @PostMapping("/cautadisc")
    public ModelAndView findDisc(@ModelAttribute("filtruDisciplina") FiltruDisciplina filtruDisciplina, Model model){
        ModelAndView modelAndView = new ModelAndView("disciplina");
        modelAndView.addObject("discipline",disciplinaRepository.findDisciplinasByAn(filtruDisciplina.getAn()));
        modelAndView.addObject("filtruDisciplina", new FiltruDisciplina());
        return  modelAndView;
    }
}
