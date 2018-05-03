package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.Disciplina;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
    List<Disciplina> findDisciplinasByAn(String an);
//    Disciplina findDisciplinaByFacultate(Facultate facultate);
}
