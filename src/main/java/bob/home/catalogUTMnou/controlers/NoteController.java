package bob.home.catalogUTMnou.controlers;

import bob.home.catalogUTMnou.model.Note;
import bob.home.catalogUTMnou.repositories.DisciplinaRepository;
import bob.home.catalogUTMnou.repositories.GrupaRepository;
import bob.home.catalogUTMnou.repositories.NoteRepository;
import bob.home.catalogUTMnou.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    private NoteRepository noteRepository;
    private GrupaRepository grupaRepository;
    private DisciplinaRepository disciplinaRepository;
    private StudentRepository studentRepository;

    public NoteController(NoteRepository noteRepository, GrupaRepository grupaRepository, DisciplinaRepository disciplinaRepository, StudentRepository studentRepository) {
        this.noteRepository = noteRepository;
        this.grupaRepository = grupaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/note")
    public String getNote(Model model){
        model.addAttribute("note",noteRepository.findAll());
        return "note";
    }

    @GetMapping("/adnote")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("grupa", grupaRepository.findAll());
        model.addAttribute("disc", disciplinaRepository.findAll());
        model.addAttribute("studenti", studentRepository.findAll());
        return "adaugaNote";
    }

//    @GetMapping("/ednote")
//    public String editOrar(@RequestParam Long id, Model model){
//        model.addAttribute("edstud", orarRepository.findById(id));
//        model.addAttribute("grupa", grupaRepository.findAll());
//        model.addAttribute("disc", disciplinaRepository.findAll());
//        model.addAttribute("prof", profesorRepository.findAll());
////        model.addAttribute("facs",facultateRepository.findAll());
//        return "adaugaOrar";
//    }

    @PostMapping("/savenote")
    public String saveNote(Note note){
        noteRepository.save(note);
        return "redirect:/note";
    }

    @GetMapping("/deletenote")
    public String deleteNote(@RequestParam Long id){
        noteRepository.deleteById(id);
        return  "redirect:/note";
    }

}
