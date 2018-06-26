import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppConfigService} from '../app-config.service';
import {Observable} from 'rxjs';
import {Match} from '../model/Match';

@Injectable()
export class ApiMatchService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public findAll(): Observable<Match[]> {
    return this.http.get<Match[]>(`${this.appConfig.url}/match`);
  }

  public create(client: Match): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}/match`, client);
  }

  public findById(id: number): Observable<Match> {
    return this.http.get<Match>(`${this.appConfig.url}/match/` + id);
  }

  public update(client: Match): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/match/` + client.id, client);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/client/` + id);
  }
}
