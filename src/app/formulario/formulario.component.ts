import { Component, OnInit } from '@angular/core';
import { LibrosService } from '../libros.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  nombre= "";
  nombreAutor= "";
  apellidoAutor= "";
  precio= 0;
  editorial= "";
  descripcion= "";
  respuesta: any;

  constructor(private librosService: LibrosService, private routes: Router) { }

  ngOnInit(): void {
  }

  async guardar(){
    var libroGuardar ={
      nombre: this.nombre,
      nombreAutor: this.nombreAutor,
      apellidoAutor: this.apellidoAutor,
      precio: this.precio,
      editorial: this.editorial,
      descripcion: this.descripcion
    }
    this.respuesta = await this.librosService.guardar(libroGuardar);

    this.routes.navigate(["/home"]);

  }

}
