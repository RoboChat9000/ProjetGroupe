import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { FormsModule } from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {UtilisateurService} from './utilisateur/utilisateur.service';
import { HttpClientModule} from '@angular/common/http';

const routes: Routes = [
  { path: 'connexion', component: UtilisateurComponent }
];


@NgModule({
  imports: [
    CommonModule, FormsModule, RouterModule.forChild(routes), HttpClientModule
  ],
  declarations: [UtilisateurComponent],
  providers: [UtilisateurService]
})
export class UtilisateurModule { }
