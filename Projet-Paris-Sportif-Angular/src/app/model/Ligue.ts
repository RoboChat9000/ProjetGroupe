import { Utilisateur} from './Utilisateur';


export class Ligue {

  constructor(public nom?: string, public listeUtilisateur?:Array<Utilisateur>, public id?: number){}

}
