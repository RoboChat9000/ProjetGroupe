import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {PariModule} from './pari/pari.module';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {AccueilComponent} from './accueil.component';
import {MatchModule} from './match/match.module';
import { UtilisateurModule} from './utilisateur/utilisateur.module';

const routes: Routes = [
  {path: 'home', component: AccueilComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes), HttpClientModule, PariModule, MatchModule, UtilisateurModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
