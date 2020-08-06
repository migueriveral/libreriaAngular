package proyecto.nuevo.libreria.dto;

public class LibroDto {

	private int id;
	private String nombre;	
	private String nombreAutor;
	private String apellidoAutor;
	private String editorial;
	private int precio;
	private String descripcion;

	public LibroDto() {
		super();
	}

	public LibroDto(int id, String nombre, String nombreAutor, String apellidoAutor, String editorial, int precio,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		this.editorial = editorial;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


}
