import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibrosService {

  url="http://localhost:8080/libro/";

  constructor(private http: HttpClient) { }

  async listar(){
    try {
      var lista = await this.http.get(this.url).toPromise();
      return lista;
    }
    catch(e){
      console.log(e);
    }
   }

  async borrar(id){
    try {
      var respuesta: any;
      respuesta = await this.http.delete(this.url + id, {responseType: "text"}).toPromise();
      return respuesta;
    }
    catch(e){
      console.log(e);
    }
  }

  async guardar(unLibro){
    try {
      var respuesta = await this.http.post(this.url, unLibro, {responseType: "text"}).toPromise();
      return respuesta;
    }
    catch(e){
      console.log(e);
    }
  }
}
