import { Component, OnInit }  from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from '../authservice/auth.service'
import {NgForm} from '@angular/forms';
import {RegistrationFormComponent} from '../registration-form/registration-form.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  private loginerror:String;
  private registrationFormToggle:boolean;

  constructor(private router:Router,private authService:AuthService) {}

  ngOnInit() {
    if(localStorage.getItem("jwtToken")){ //check if its valid, dont just wether it exists or not.
      this.router.navigate(['']);
    }
    this.registrationFormToggle = false;
  }

  attemptLogin(loginForm:NgForm){
      this.authService.login(loginForm.value).subscribe(
        res=>{
          localStorage.setItem("jwtToken",res['token']);
          this.router.navigate(['']);
        },
        err=>{
          this.loginerror = "Wrong username or password!";
        }
      )
  }

  showHideRegistrationForm(){
    this.registrationFormToggle = !this.registrationFormToggle;
  }
}
