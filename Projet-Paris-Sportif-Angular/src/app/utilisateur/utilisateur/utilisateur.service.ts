import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppConfigService} from 'src/app/app-config.service';
import {Observable} from 'rxjs';
import {Utilisateur} from '../../model/Utilisateur';
import {UtilisateurComponent} from './utilisateur.component';

@Injectable()
export class UtilisateurService {

 constructor(private appConfig: AppConfigService, private http: HttpClient) { }

  public pseudoError: boolean = false;

  public findAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.appConfig.url}/`);
  }

  public create(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.appConfig.url}/inscription/`, Utilisateur);
  }

  public findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.appConfig.url}/` + id);
  }

  public update(utilisateur: Utilisateur): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/` + utilisateur.id, Utilisateur);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/` + id);
  }

  public verifPseudoBDD(pseudo: string): void
  {
   this.http.get<boolean>(`${this.appConfig.url}/inscription/` + pseudo).subscribe(resp => this.pseudoError = resp);
  }

  public login(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.appConfig.url}/login/`, utilisateur);
  }

  public getPseudoError(pseudo: string):boolean
  {
    return this.pseudoError;
  }

}


