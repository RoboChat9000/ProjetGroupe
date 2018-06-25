import {Equipe} from './Equipe';

export class Poule {

  constructor(public id: number, public nom?: string, public listeEquipes?: Array<Equipe>) {}
}
