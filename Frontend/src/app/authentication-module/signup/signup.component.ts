import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {AuthService} from '../authservice/auth.service';

@Component({
  selector: 'registration-form',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private registrationErrors={};

  constructor(private authService:AuthService,private router:Router) {}

  ngOnInit() {}

  attemptUserRegistration(regForm:NgForm){
    regForm.value.email+='@sample-text.com';
    this.authService.register(regForm.value).subscribe(
      res=>{
      },
      err=>{
        this.registrationErrors=err.error;
        if(err.status === 200){
          this.router.navigate(['login']);
        }
      }
    )
  }

  doPasswordsMatch(pw1,pw2){
    return pw1===pw2 && pw1!=null && pw2!=null;
  }

  goBackToLogin(){
    this.router.navigate(['login']);
  }
}