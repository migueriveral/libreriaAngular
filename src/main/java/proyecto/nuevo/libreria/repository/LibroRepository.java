package proyecto.nuevo.libreria.repository;
import org.springframework.data.repository.CrudRepository;

import proyecto.nuevo.libreria.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Integer>{

	Libro findByNombre(String nombre);
}
