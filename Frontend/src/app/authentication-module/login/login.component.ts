import { Component, OnInit, SecurityContext}  from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../authservice/auth.service';
import { NgForm } from '@angular/forms';

import {MatIconRegistry} from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit{
  private loginerror:String;

  constructor(private router:Router,private authService:AuthService,
              private iconRegistry:MatIconRegistry,private sanitizer:DomSanitizer) {}

  ngOnInit() {
    if(localStorage.getItem("jwtToken")){ //check if its valid, dont just wether it exists or not.
      this.router.navigate(['']);
    }
    this.iconRegistry.addSvgIcon('warning-triangle',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/warning.svg'));
  }

  attemptLogin(loginForm:NgForm){
      this.authService.login(loginForm.value).subscribe(
        res=>{
          localStorage.setItem("jwtToken",res['token']);
          this.router.navigate(['']);
        },
        err=>{
          this.loginerror = "Invalid username or password!";
        }
      )
  }

  switchRouteToSignUp(){
    this.router.navigate(['signup']);
  }
}
