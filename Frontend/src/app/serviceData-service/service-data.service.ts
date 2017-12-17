import { Injectable } from '@angular/core';
import { Router } from '@angular/router/';
import { Observable } from 'rxjs/Observable';
import { HttpClient,HttpHeaders } from '@angular/common/http'
import { Subscription } from 'rxjs/Subscription';


@Injectable()
export class ServiceData_Service {
  private baseTargetUrl = 'http://localhost:8080/services';
  private headers:HttpHeaders;

  constructor(private router:Router,private http:HttpClient) {
    this.headers = new HttpHeaders(
      {
          'authorization':localStorage.getItem('jwtToken')
      });
  }

  getServiceNames():Observable<Object>{
    return this.http.get(this.baseTargetUrl,{headers:this.headers});
  }

  getServiceDescription(id:number):Observable<any>{
    return this.http.get(this.baseTargetUrl+'/'+id,{headers:this.headers});
  }

  getServiceRequestForm(id:number):Observable<any>{
    return this.http.get(this.baseTargetUrl+'/'+id+'/request',{headers:this.headers});
  }
  
}