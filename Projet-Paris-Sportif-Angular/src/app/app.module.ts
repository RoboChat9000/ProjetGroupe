import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {PariModule} from './pari/pari.module';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AccueilComponent} from './accueil.component';

const routes: Routes = [
  {path: 'home', component: AccueilComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes), HttpClientModule, PariModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
