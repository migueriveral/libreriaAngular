import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContenedorComponent } from './contenedor/contenedor.component';
import { FormularioComponent } from './formulario/formulario.component';


const routes: Routes = [
  {path: "", component: ContenedorComponent},
  {path: "home", component: ContenedorComponent},
  {path: "form", component: FormularioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
