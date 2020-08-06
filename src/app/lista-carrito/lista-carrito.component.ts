import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { CarritoService } from '../carrito.service';

@Component({
  selector: 'app-lista-carrito',
  templateUrl: './lista-carrito.component.html',
  styleUrls: ['./lista-carrito.component.css']
})
export class ListaCarritoComponent implements OnInit {
  @Input() unProducto;
  @Input() carrito;

  mensaje: any;
  total= 0;

  constructor(private carritoService: CarritoService) { }

  ngOnInit(): void {
  }

  async finalizarCompra(){
    this.mensaje = await this.carritoService.checkout(this.carrito);
  }

  borrarDelCarrito(unProducto){
    var indice = this.carrito.findIndex(item => item.nombre == unProducto.nombre);
    this.carrito.splice(indice, 1);
  }


}
