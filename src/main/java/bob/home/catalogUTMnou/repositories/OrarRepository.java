package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.AnScolar;
import bob.home.catalogUTMnou.model.Orar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrarRepository extends CrudRepository<Orar, Long> {

    List<Orar> findOrarByAnScolarAndAnAndSemestru(AnScolar anScolar, String an, String semestru);
//    List<Orar>
}
