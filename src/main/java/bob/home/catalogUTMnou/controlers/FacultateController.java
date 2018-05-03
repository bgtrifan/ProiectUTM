package bob.home.catalogUTMnou.controlers;


import bob.home.catalogUTMnou.model.Facultate;
import bob.home.catalogUTMnou.repositories.FacultateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacultateController {

    private FacultateRepository facultateRepository;

    public FacultateController(FacultateRepository facultateRepository){
        this.facultateRepository = facultateRepository;
    }

    @RequestMapping("/facultate")
    public String getFacultate(Model model){
        model.addAttribute("fac", facultateRepository.findAll());
        return "fac";
    }

    @GetMapping("/adfac")
    public String add(Model model) {
        model.addAttribute("adaugaFac", new Facultate());
        return "adaugaFac";
    }

    @GetMapping("/edfac")
    public String edit(@RequestParam Long id, Model model){
        model.addAttribute("adaugaFac", facultateRepository.findById(id));
        return "adaugaFac";
    }

    @PostMapping("/savefac")
    public String save(Facultate facultate){
        facultateRepository.save(facultate);
        return "redirect:/facultate";
    }

    @GetMapping("/deletefac")
    public String delete(@RequestParam Long id){
        facultateRepository.deleteById(id);
        return  "redirect:/facultate";
    }

}
