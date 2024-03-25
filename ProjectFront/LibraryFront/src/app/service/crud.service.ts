import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Url } from '../module/Url';
import { Issue } from '../module/Issue';

@Injectable({
  providedIn: 'root'
})
export class CrudService<T> {

  token = localStorage.getItem('jwtToken');
  
  constructor(private httpclient: HttpClient,private Url:Url) { }

  headers = new HttpHeaders().set('Authorization', `Bearer `+this.token);
  getAll(page: Number,size:Number,sortedby:string,direction:string) :Observable<any>
    {
      const params = new HttpParams().set("page",page.toString()).set("size",size.toString()).set("sort",`${sortedby},${direction}`);
     
      return(this.httpclient.get(this.Url.url,{headers: this.headers,params}));
    }

    getId(id:number) :Observable<T>
  {
    
    return(this.httpclient.get<T>(this.Url.url+`/${id}`,{headers: this.headers}));
  }
   
  add(item:T):Observable<any>
  {
    console.log(this.Url.url);
    return(this.httpclient.post(this.Url.url, item,{headers: this.headers}));
  }

  edit(item:Issue):Observable<any>
  {
    item.returnDate=new Date();
    return(this.httpclient.post(this.Url.url+"/Edit", item,{headers: this.headers}));
  }

  delete(id:Number):Observable<any>
  {
    console.log(this.Url.url+`/${id}`);
    return(this.httpclient.delete(this.Url.url+`/${id}`,{headers: this.headers}));
  }


  search(searchvalue:string,page: Number,size:Number,sortedby:string,direction:string ):Observable<any>
  {
    const params = new HttpParams().set('name', searchvalue).set("page","0").set("size",size.toString()).set("sort",`${sortedby},${direction}`);
    return(this.httpclient.get(this.Url.url+"/search",{headers: this.headers,params}));
  }
}
