import { HttpClient,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisterRequest } from '../module/registerRequest';
import { AuthRequest } from '../module/authRequest';
import {environment} from "../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl=environment.apiUrl
  constructor( private httpclient: HttpClient) { }

  add(request:RegisterRequest):Observable<any>
  {

    return(this.httpclient.post(this.baseUrl+"/registerr", request));
  }
  authenticate(request:AuthRequest):Observable<any>
  {

    return(this.httpclient.post(this.baseUrl, request));
  }
  getUser( token:string):Observable<any>
  {
    const params = new HttpParams().set("token",token)
    return(this.httpclient.get(this.baseUrl,{params}));
  }

}
