package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.Grupa;
import bob.home.catalogUTMnou.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findStudentsByNume(String nume);
    List<Student> findStudentsByGrupa(Grupa grupa);
    Student findStudentsByCnp(String cnp);

}
