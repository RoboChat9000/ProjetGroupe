import { Component, OnInit } from '@angular/core';
import {Utilisateur} from '../../model/Utilisateur';
import {UtilisateurService} from './utilisateur.service';
import {visitAstChildren} from '@angular/compiler';
import {Router} from '@angular/router';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {

  public formUtilisateur: Utilisateur = null;
  public utilisateurs: Array<Utilisateur>;
public visibilityInscription: boolean = false;
  public visibilitylogin: boolean = true;
  public mdpConf: string;

  constructor(public utilisateurService: UtilisateurService, private router: Router) {
    this.list();
  }

  ngOnInit() {
  }

  public list(){
    this.utilisateurService.findAll().subscribe(resp => {
      this.utilisateurs = resp;
    });

  }

  public login() {
    this.utilisateurService.login(this.formUtilisateur).subscribe(resp => {
      this.formUtilisateur = resp;
      localStorage.setItem('utilisateur', JSON.stringify(this.formUtilisateur));
      this.router.navigateByUrl('<path_to_homepage>');
    });
  }

  public inscription() {
    if (this.mdpConf === this.formUtilisateur.mdp && this.utilisateurService.verifPseudoBDD(this.formUtilisateur.pseudo)) {
      this.utilisateurService.create(this.formUtilisateur).subscribe(resp => {
        this.formUtilisateur = resp;
        localStorage.setItem('utilisateur', JSON.stringify(this.formUtilisateur));
        this.router.navigateByUrl('<path_to_homepage>');
      });
    }
  }

  public visibility() {
  if (this.visibilityInscription === false && this.visibilitylogin === true) {
    this.visibilityInscription = true;
    this.visibilitylogin = false;
  } else {
    this.visibilityInscription = false;
  this.visibilitylogin = true;
  }
  }

}
