import {Poule} from './Poule';
import {Match} from './Match';

export class Equipe {
  constructor(public id?: number, public poule?: Poule, public nom?: string, public iso?: string, public listeMatchs?: Array<Match>) {}
}
