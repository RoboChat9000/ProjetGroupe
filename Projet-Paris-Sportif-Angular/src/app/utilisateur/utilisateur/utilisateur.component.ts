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

  public formUtilisateur: Utilisateur = new Utilisateur(null, 'bla', null, 'bla', null, null, null);
  public utilisateurs: Array<Utilisateur>;
public visibilityInscription: boolean = false;
  public visibilitylogin: boolean = true;
  public mdpConf: string;
public pseudoError: boolean;

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
     // alert(JSON.parse(localStorage.getItem('utilisateur')).id);
      this.router.navigateByUrl('/match/' + this.formUtilisateur.id);
    });
  }

  public inscription() {
    if (this.mdpConf === this.formUtilisateur.mdp && this.utilisateurService.getPseudoError() === true) {
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

  public getPseudoError(): boolean
  {
    this.utilisateurService.verifPseudoBDD(this.formUtilisateur.pseudo);
    this.pseudoError =  this.utilisateurService.getPseudoError(this.formUtilisateur.pseudo)
    return this.pseudoError;
  }

  /*
public verifPseudoBDD()
{
  alert(this.utilisateurService.verifPseudoBDD(this.formUtilisateur.pseudo));
  this.pseudoError = this.utilisateurService.verifPseudoBDD(this.formUtilisateur.pseudo);
  alert(this.pseudoError);
}*/
}
