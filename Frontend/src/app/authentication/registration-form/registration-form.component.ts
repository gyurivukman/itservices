import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

import {AuthService} from '../authservice/auth.service';

@Component({
  selector: 'registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  registrationErrors={};

  constructor(private authService:AuthService) {}

  ngOnInit() {}

  attemptUserRegistration(regForm:NgForm){
    this.authService.register(regForm.value).subscribe(
      res=>{},
      err=>{
        this.registrationErrors=err.error;
      }
    )
  }

  doPasswordsMatch(pw1,pw2){
    return pw1===pw2;
  }
}
