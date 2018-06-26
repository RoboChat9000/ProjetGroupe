import { Component, OnInit } from '@angular/core';
import {Pari} from '../model/Pari';
import {ApiPariService} from './pari.service';
import {ActivatedRoute} from '@angular/router';
import {DateFormatter} from '@angular/common/src/pipes/deprecated/intl';

@Component({
  selector: 'app-pari',
  templateUrl: './pari.component.html',
  styleUrls: ['./pari.component.css']
})
export class PariComponent implements OnInit {

  public pari: Pari = new Pari();
  public idMatch: number;
  public validation: string = '';

  constructor(public pariService: ApiPariService, private route: ActivatedRoute) {
    this.route.params.subscribe(parametre => {
      this.idMatch = parametre['id'];
    });
    this.pariService.findById(this.idMatch).subscribe(resp => {
      this.pari = resp;
      this.pari.matchId = this.idMatch;
      this.pari.utilisateurId = 1;
    });
  }

  public modifierPari(pari: Pari) {
    if (this.valider(new Date())) {
      const dateFormattee = this.affecterDate(new Date());
      pari.date = dateFormattee;

      console.log(pari.match.date);
      this.pariService.update(pari).subscribe(resp => {
        console.log(resp);
      });
      this.validation = 'valide';
    } else {
      this.validation = 'nonValide';
    }
  }


  public creerPari(pari: Pari) {
    if (this.valider(new Date())) {
      const dateFormattee = this.affecterDate(new Date());
      pari.date = dateFormattee;

      this.pariService.create(pari).subscribe(resp => {
        console.log(resp);
      });
      this.validation = 'valide';
    } else {
      this.validation = 'nonValide';
    }

  }


  public valider(dateNow: Date): boolean {
    if (dateNow < new Date(this.pari.match.date)) {
      return true;
    } else {
      return false;
    }
  }
  public affecterDate(date: Date){
    var day = date.getDate();
    var monthIndex = date.getMonth();
    var year = date.getFullYear();
    var minutes = date.getMinutes();
    var hours = date.getHours();
    return year + "-" + (monthIndex+1) + "-" + day + " " + hours + ":" + minutes;
  }

  public listPari(){

  }

  ngOnInit() {
  }

}
