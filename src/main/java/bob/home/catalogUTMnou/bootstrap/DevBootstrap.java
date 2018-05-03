package bob.home.catalogUTMnou.bootstrap;

import bob.home.catalogUTMnou.model.*;
import bob.home.catalogUTMnou.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private GrupaRepository grupaRepository;
    private FacultateRepository facultateRepository;
    private StudentRepository studentRepository;
    private RoleRepository rolesRepository;
    private DisciplinaRepository disciplinaRepository;
    private ProfesorRepository profesorRepository;
    private UserRepository usersRepository;


    public DevBootstrap(GrupaRepository grupaRepository, FacultateRepository facultateRepository, StudentRepository studentRepository, RoleRepository rolesRepository, DisciplinaRepository disciplinaRepository, ProfesorRepository profesorRepository) {
        this.grupaRepository = grupaRepository;
        this.facultateRepository = facultateRepository;
        this.studentRepository = studentRepository;
        this.rolesRepository = rolesRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //UTM
        Facultate facultate = new Facultate("UTM","Zi");
        facultateRepository.save(facultate);

        //grupa1
//        Grupa grupa1 = new Grupa("201", "2017", "1", facultate, "2017-2018");
//        grupaRepository.save(grupa1);


        //Profesor
        Profesor profesor = new Profesor("Dorel", "Visanel", "1123", "user2", "parola", "222", "profu@p.p");
        profesorRepository.save(profesor);

//        //Disciplina
//        Disciplina disciplina1 = new Disciplina("mate", "3", facultate, "2018", "2", grupa1);
//



//        //role
//        Roluri role1 = new Roluri("ADMIN");
//        Roluri role2 = new Roluri("STUDENT");
//        Roluri role3 = new Roluri("PROFESOR");

//        rolesRepository.save(role1);
//        rolesRepository.save(role2);
//        rolesRepository.save(role3);

        //USERS
//        User user1 = new User("user", "parola", role1, 1);
//        usersRepository.save(user1);





        //Student
        Student gigi = new Student("Gigi",
                                   "Masinuta",
                                    "12345678",
                                    "Str. Sperantei",
                                    "088 888 888",
                                    "a@bc.d",
                                    null, "gigiM", "parola","1.1.2001",facultate,"2018", "2018");

        studentRepository.save(gigi);
    }
}
