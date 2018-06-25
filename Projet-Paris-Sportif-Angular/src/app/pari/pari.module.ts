import { NgModule } from '@angular/core';
import {PariComponent} from './pari.component';
import {RouterModule, Routes} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ApiPariService} from './pari.service';

const routes: Routes = [
  {path: 'match/:id', component: PariComponent}
];

@NgModule({
  imports: [
    BrowserModule, FormsModule, RouterModule.forChild(routes), HttpClientModule
  ],
  declarations: [PariComponent],
  providers: [ApiPariService]
})
export class PariModule { }
