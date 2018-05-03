package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Examene;
import bob.home.catalogUTMnou.model.FiltruExamen;
import bob.home.catalogUTMnou.repositories.DisciplinaRepository;
import bob.home.catalogUTMnou.repositories.ExamemeRepository;
import bob.home.catalogUTMnou.repositories.GrupaRepository;
import bob.home.catalogUTMnou.repositories.ProfesorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExameneController {

    private ExamemeRepository examemeRepository;
    private GrupaRepository grupaRepository;
    private DisciplinaRepository disciplinaRepository;
    private ProfesorRepository profesorRepository;

    public ExameneController(ExamemeRepository examemeRepository, GrupaRepository grupaRepository, DisciplinaRepository disciplinaRepository, ProfesorRepository profesorRepository) {
        this.examemeRepository = examemeRepository;
        this.grupaRepository = grupaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.profesorRepository = profesorRepository;
    }

    @RequestMapping("/examene")
    public String getExamene(Model model){
        model.addAttribute("examene", examemeRepository.findAll());
        model.addAttribute("filtruExamen", new FiltruExamen());
        return "examene";
    }

    @GetMapping("/adexam")
    public String addExam(Model model) {
        model.addAttribute("examene", new Examene());
        model.addAttribute("grupa", grupaRepository.findAll());
        model.addAttribute("disc", disciplinaRepository.findAll());
        model.addAttribute("prof", profesorRepository.findAll());
        return "adaugaExamen";
    }

    @PostMapping
    @RequestMapping("/edexamen")
    public String editExam(@RequestParam Long id, Model model){
//        model.addAttribute("edstud", orarRepository.findById(id));
//        model.addAttribute("grupa", grupaRepository.findAll());
//        model.addAttribute("disc", disciplinaRepository.findAll());
//        model.addAttribute("prof", profesorRepository.findAll());
//        model.addAttribute("facs",facultateRepository.findAll());
        return "adaugaExamen";
    }

    @PostMapping
    @RequestMapping("/saveexamen")
    public String saveExam(Examene examene){
        examemeRepository.save(examene);
        return "redirect:/examene";
    }

    @PostMapping
    @RequestMapping("/deletexamene")
    public String deleteExam(@RequestParam Long id){
        examemeRepository.deleteById(id);
        return  "redirect:/examene";
    }

    @PostMapping("/cautaexamen")
    public ModelAndView findOrar(@ModelAttribute("filtruExamen") FiltruExamen filtru, Model model){
        ModelAndView modelAndView = new ModelAndView("examene");
        modelAndView.addObject("examene",examemeRepository.findExameneByAnScolarAndAnAndSemestru(filtru.getAnScolar(),filtru.getAn(),filtru.getSemestru()));
        modelAndView.addObject("filtruExamen", new FiltruExamen());
        return  modelAndView;
    }
}
