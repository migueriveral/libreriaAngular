import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent implements OnInit {

  @Input() lista;
  @Output() agregarEvent = new EventEmitter;
  @Output() eliminarEvent = new EventEmitter;

  constructor() { }

  ngOnInit(): void {
  }

  agregarCarrito(unProducto){
    this.agregarEvent.emit(unProducto);
  }

  eliminar(id){
    this.eliminarEvent.emit(id);
  }


}
