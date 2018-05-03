package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Filtru;
import bob.home.catalogUTMnou.model.Student;
import bob.home.catalogUTMnou.repositories.FacultateRepository;
import bob.home.catalogUTMnou.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentControler {

    private StudentRepository studentRepository;
    private FacultateRepository facultateRepository;

    public StudentControler(StudentRepository studentRepository,  FacultateRepository facultateRepository){
        this.studentRepository = studentRepository;
        this.facultateRepository = facultateRepository;
    }

    @RequestMapping("/students")
    public String getStudent(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("filtru", new Filtru());
        return "student";
    }

    @GetMapping("/adstud")
    public String addStudent(Model model) {
        model.addAttribute("adstud", new Student());
//        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("facs",facultateRepository.findAll());
        return "adaugaStud";
    }

    @GetMapping("/edstud")
    public String editStudent(@RequestParam Long id, Model model){
        model.addAttribute("adstud", studentRepository.findById(id));
//        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("facs",facultateRepository.findAll());
        return "adaugaStud";
    }

    @PostMapping("/savestud")
    public String save(Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/deletestud")
    public String delete(@RequestParam Long id){
        studentRepository.deleteById(id);
        return  "redirect:/student";
    }

    @PostMapping("/cautastud")
    public ModelAndView findStud(@ModelAttribute("filtru") Filtru filtru, Model model){
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("students",studentRepository.findStudentsByCnp(filtru.getCnp()));
        modelAndView.addObject("filtru", new Filtru());
        return  modelAndView;
    }

}
