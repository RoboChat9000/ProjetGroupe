import {Equipe} from './Equipe';
import {Match} from './Match';

export class Pari {
  constructor(public utilisateurId: number, public matchId: number, public match?: Match, public resultatDom?: number,
              public resultatExt?: number, public vainqueur?: Equipe, public date?: any){}
}
