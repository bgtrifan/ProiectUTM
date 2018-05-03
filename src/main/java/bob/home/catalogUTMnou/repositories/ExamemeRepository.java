package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.AnScolar;
import bob.home.catalogUTMnou.model.Examene;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExamemeRepository extends CrudRepository<Examene, Long> {

    List<Examene> findExameneByAnScolarAndAnAndSemestru(AnScolar anScolar, String an, String semestru);
}
