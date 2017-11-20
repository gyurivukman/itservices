import { Component, OnInit }  from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from '../authservice/auth.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  private loginerror:String;

  constructor(private router:Router,private authService:AuthService) {}

  ngOnInit() {
    if(localStorage.getItem("jwtToken")){ //check if its valid, dont just wether it exists or not.
      this.router.navigate(['']);
    }
  }

  attemptLogin(username:String, password:String){
    if(!username || !password){
      this.loginerror="Please enter a username and password!";
    }else{
      this.authService.login(username,password).subscribe(
        res=>{
          localStorage.setItem("jwtToken",res['token']);
          this.router.navigate(['']);
        },
        err=>{
          this.loginerror = "Wrong username or password!";
        }
      )
    }
  }
}
