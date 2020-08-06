package proyecto.nuevo.libreria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Length(min=2, max=50)
	private String nombre;
	
	@NotEmpty
	@Length(min=2, max=50)
	private String nombreAutor;
	
	@NotEmpty
	@Length(min=2, max=50)
	private String apellidoAutor;

	
	@NotNull
	private int precio;

	@NotEmpty
	@Length(min=2, max=50)
	private String editorial;

	@NotEmpty
	@Length(min=2, max=250)
	private String descripcion;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Libro() {
		super();
	}

	public Libro(@NotEmpty @Length(min = 2, max = 50) String nombre,
			@NotEmpty @Length(min = 2, max = 50) String nombreAutor,
			@NotEmpty @Length(min = 2, max = 50) String apellidoAutor, @NotEmpty int precio,
			@NotEmpty @Length(min = 2, max = 50) String editorial,
			@NotEmpty @Length(min = 2, max = 250) String descripcion) {
		super();
		this.nombre = nombre;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		this.precio = precio;
		this.editorial = editorial;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
