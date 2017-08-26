import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Checkpost } from '../classes/checkpost';
import { CheckpostPanel } from '../classes/checkpost-panel';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class MainService {

  private controllerUrl: string;
  private headers = new Headers({'Content-Type': 'application/json'});
  private checkpostsUrl = 'api/checkpostPanels';  // URL to web api

  constructor(private http: Http) {
    this.http = http;
    this.controllerUrl = 'http://localhost:8080/findAll/';
  }

  getData(): Observable<any[]> {
    return this.http
      .get(this.controllerUrl)
      .map(res => res.json() as any[]);
  }

  getCheckposts(): Promise<Checkpost[]> {
    return this.http.get(this.checkpostsUrl)
               .toPromise()
               .then(response => response.json().data as Checkpost[])
               .catch(this.handleError);
  }

  getCheckpostPanels(): Promise<CheckpostPanel[]> {
    return this.http.get(this.checkpostsUrl)
               .toPromise()
               .then(response => response.json().data as CheckpostPanel[])
               .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}