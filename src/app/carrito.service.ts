import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  url="http://localhost:8080/carrito/";

  constructor(private http: HttpClient) { }

  async checkout(carrito){
    try {
      var respuesta = await this.http.post(this.url, carrito, {responseType: "text"}).toPromise();
      return respuesta;
    }
    catch(e){
      console.log(e);
    }
  }

}

