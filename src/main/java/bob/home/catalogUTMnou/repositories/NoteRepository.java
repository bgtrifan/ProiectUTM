package bob.home.catalogUTMnou.repositories;

import bob.home.catalogUTMnou.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
