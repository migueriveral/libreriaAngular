import { Component, OnInit } from '@angular/core';
import { LibrosService } from '../libros.service';

@Component({
  selector: 'app-contenedor',
  templateUrl: './contenedor.component.html',
  styleUrls: ['./contenedor.component.css']
})
export class ContenedorComponent implements OnInit {

  productos: any;
  productosCarrito = [];


  constructor(private librosService: LibrosService) { }

  async ngOnInit() {
    this.productos = await this.librosService.listar();
  }

  agregarCarrito(unProducto){
    this.productosCarrito.push(unProducto);
  }


  async eliminarDelListado(id){
    var respuesta: any;
    respuesta = await this.librosService.borrar(id);
    this.ngOnInit();
  }


}


