import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import { Router, CanActivate } from '@angular/router';
import { HttpClient,HttpHeaders } from '@angular/common/http'

@Injectable()
export class AuthService implements CanActivate{

  constructor(private router:Router,private http:HttpClient) {}

  canActivate() {
    if(localStorage.getItem('jwtToken')) {
      // logged in so return true
      return true;
    }
    // not logged in so redirect to login page
      this.router.navigate(['login']);
      return false;
    }

  login(username:String,password:String):Observable<Object>{
    const targetUrl = 'http://localhost:8080/auth/login';
    const body = {username,password};
    const headers = new HttpHeaders(
      {
          'Content-Type': 'application/json'
      });

    return this.http.post(targetUrl,body,{headers:headers});
  }

  logout(){
    localStorage.removeItem("jwtToken");
    this.router.navigate(['login']);
  }
}