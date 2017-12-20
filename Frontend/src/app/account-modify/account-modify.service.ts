import { Injectable } from '@angular/core'
import { Router, CanActivate } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable()
export class AccountModifyService {

  constructor(private router: Router, private http: HttpClient) { }

  canActivate() {
    if (localStorage.getItem('jwtToken')) {
      // logged in so return true
      return true;
    }
    // not logged in so redirect to login page
    this.router.navigate(['login']);
    return false;
  }

  logout(){
    localStorage.removeItem('jwtToken');
    this.router.navigate(['login']);
  }

  login(username, password):Observable<Object>{
    const targetUrl = 'http://localhost:8080/auth/login';
    const body = {username, password};
    const headers = new HttpHeaders(
      {
          'Content-Type': 'application/json'
      });

    return this.http.post(targetUrl,body,{headers:headers});
  }

  getUser(): Observable<Object> {
    const targetUrl = 'http://localhost:8080/user/getuser';
    const body = localStorage.getItem('jwtToken');
    const headers = new HttpHeaders(
      {
        'Content-Type': 'application/json'
      });

    return this.http.post(targetUrl, body, { headers: headers });
  }

  modify(userData): Observable<Object> {
    const targetUrl = 'http://localhost:8080/user/modify';
    const body = userData;
    const headers = new HttpHeaders(
      {
        'Content-Type': 'application/json'
      });

    return this.http.post(targetUrl, body, { headers: headers });
  }

}
