import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthService } from '../authservice/auth.service';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'registration-form',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  position = 'before';
  private registrationErrors={};

  constructor(private authService:AuthService,private router:Router,private iconRegistry:MatIconRegistry,private sanitizer:DomSanitizer) {}

  ngOnInit() {
    this.iconRegistry.addSvgIcon('warning-triangle',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/warning.svg'));
    this.iconRegistry.addSvgIcon('information',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/information.svg'));
  }

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