import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConfigService} from '../app-config.service';
import {Pari} from '../model/Pari';

@Injectable()
export class ApiPariService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public create(pari: Pari): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}/match/` + pari.matchId, pari);
  }

  public findById(id: number): Observable<Pari> {
    return this.http.get<Pari>(`${this.appConfig.url}/match/` + id);
  }

  public update(pari: Pari): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/match/` + pari.matchId, pari);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/match/` + id);
  }
}
