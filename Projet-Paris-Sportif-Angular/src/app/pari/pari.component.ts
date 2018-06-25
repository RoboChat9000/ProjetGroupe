import { Component, OnInit } from '@angular/core';
import {Pari} from '../model/Pari';
import {ApiPariService} from './pari.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-pari',
  templateUrl: './pari.component.html',
  styleUrls: ['./pari.component.css']
})
export class PariComponent implements OnInit {

  public pari: Pari = new Pari();

  constructor(public pariService: ApiPariService, private route: ActivatedRoute) {
    let id: number;
    this.route.params.subscribe(parametre => {
      id = parametre['id'];
    });
    this.pariService.findById(id).subscribe(resp => {
      this.pari = resp;
    });
  }

  ngOnInit() {
  }

}
