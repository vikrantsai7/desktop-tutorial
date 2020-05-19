import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PhoneComponent } from './phone/phone.component'; 
import { AboutComponent } from './about/about.component'; 


const routes: Routes = [
{ path: 'phone', component: PhoneComponent },
{ path: 'about', component: AboutComponent }, 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
