import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ApiMatchService} from './api-match.service';
import {MatchComponent} from './match.component';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  { path: 'match', component: MatchComponent }
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes)
  ],
  declarations: [
    MatchComponent
  ],
  providers: [
    ApiMatchService
  ]
})
export class MatchModule { }
