import {Equipe} from './Equipe';
import {Stade} from './Stade';
import {Cote} from './Cote';

export class Match {

  constructor(public id: number, public equipeDom?: Equipe, public equipeExt?: Equipe, public resultatDom?: number,
              public resultatExt?: number, public cote?: Cote, public stade? : Stade, public phase?: string, public date?: any){}

}
