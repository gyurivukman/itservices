import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthService implements CanActivate{

  constructor(private router:Router) {}

  canActivate() {
    if(localStorage.getItem('jwtToken')) {
      // logged in so return true
      return true;
    }
    // not logged in so redirect to login page
      this.router.navigate(['login']);
      return false;
    }

  logout(){
    localStorage.removeItem("jwtToken");
    this.router.navigate(['login']);
  }
}