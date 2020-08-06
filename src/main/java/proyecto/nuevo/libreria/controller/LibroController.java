package proyecto.nuevo.libreria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.nuevo.libreria.dto.LibroDto;
import proyecto.nuevo.libreria.model.Libro;
import proyecto.nuevo.libreria.repository.LibroRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("libro")
public class LibroController {

	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping("/")
	public ResponseEntity listarTodos() {
    	try {
	    	Iterable<Libro> lista;
	    	
	    	
	    	lista = libroRepository.findAll();
	    	
	    	return ResponseEntity.ok(lista);
    	}
    	catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
    	}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarUno(@PathVariable int id) {
		try {
			Optional<Libro> libro;
			
			libro = libroRepository.findById(id);
			
			if(libro.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se encuentra el libro");
			}
			return ResponseEntity.ok(libro.get());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema: "+e);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity guardarNuevo(@RequestBody LibroDto libro) {
		try {
			Libro libroGuardar;

			
			 if(libro.getNombre().isEmpty() || libro.getNombreAutor().isEmpty() ||
			 libro.getApellidoAutor().isEmpty() || libro.getPrecio()<1 ||
			 libro.getEditorial().isEmpty() || libro.getDescripcion().isEmpty()){ 
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faltan datos del libro");
			 }
			 		
			libroGuardar = new Libro();
			
			libroGuardar.setNombre(libro.getNombre());
			libroGuardar.setNombreAutor(libro.getNombreAutor());
			libroGuardar.setApellidoAutor(libro.getApellidoAutor());
			libroGuardar.setPrecio(libro.getPrecio());
			libroGuardar.setEditorial(libro.getEditorial());
			libroGuardar.setDescripcion(libro.getDescripcion());
			
			libroRepository.save(libroGuardar);
						
			return ResponseEntity.ok(libroGuardar);
			
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un error grave: "+e);
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity modificar(@PathVariable int id, @RequestBody LibroDto unLibro) {
		try {
			Optional<Libro> libroOpt;
			Libro libroModificado;
			
			if(unLibro.getNombre().isEmpty()||unLibro.getNombreAutor().isEmpty()||unLibro.getApellidoAutor().isEmpty()||unLibro.getPrecio()<0||unLibro.getEditorial().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faltan datos del libro");
			}
			
			libroOpt = libroRepository.findById(id);
			if(libroOpt.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe ese libro");
			}
			
			libroModificado = libroOpt.get();
			
			libroModificado.setNombre(unLibro.getNombre());
			libroModificado.setNombreAutor(unLibro.getNombreAutor());
			libroModificado.setApellidoAutor(unLibro.getApellidoAutor());
			libroModificado.setEditorial(unLibro.getEditorial());
			libroModificado.setPrecio(unLibro.getPrecio());
			libroModificado.setDescripcion(unLibro.getDescripcion());
			
			libroRepository.save(libroModificado);
			return ResponseEntity.ok(libroModificado);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema: "+e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity borrar(@PathVariable int id) {
		try {
			
			if(!libroRepository.findById(id).isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontró el libro");
			}
		
			libroRepository.deleteById(id);
			
			return ResponseEntity.ok("Se borro correctamente");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un error grave: "+e);
		}
		
	}

	

}
