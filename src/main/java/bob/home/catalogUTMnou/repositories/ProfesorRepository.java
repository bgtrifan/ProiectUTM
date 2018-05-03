package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

    Profesor findProfesorByCnp(String cnp);
}
