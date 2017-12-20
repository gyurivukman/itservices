import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient,HttpHeaders } from '@angular/common/http'

@Injectable()
export class RequestsService {

  constructor(private http:HttpClient) {}

  public getRequestsMetadata():Observable<any>{
    let headers = new HttpHeaders({
      'authorization':localStorage.getItem('jwtToken')
    })

    return this.http.get('http://localhost:8080/user/requests',{headers:headers});
  }

  public getRequestData(id:number):Observable<any>{
    let headers = new HttpHeaders({
      'authorization':localStorage.getItem('jwtToken')
    })

    return this.http.get('http://localhost:8080/requests/'+id,{headers:headers});
  }
}