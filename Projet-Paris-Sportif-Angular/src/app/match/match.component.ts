import { Component, OnInit } from '@angular/core';
import {Match} from '../model/Match';
import {ApiMatchService} from './api-match.service';
import {Pari} from '../model/Pari';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {
  public matchs: Array<Match> = new Array<Match>();
  public match: Match = null;

  constructor(public matchsService: ApiMatchService) {
    this.list();
  }

  ngOnInit() {
  }
  private list() {

    this.matchsService.findAll().subscribe(resp => {
      this.matchs = resp;
    });
  }
}
