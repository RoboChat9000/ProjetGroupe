import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  public url: string = 'http://localhost:8080';

  constructor() { }
}
