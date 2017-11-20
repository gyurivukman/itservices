import { Component, OnInit }  from '@angular/core';
import { Router}  from '@angular/router';
import {HttpClient,HttpHeaders} from '@angular/common/http'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  private loginerror:String;

  constructor(private router:Router,private http:HttpClient) {}

  ngOnInit() {
    if(localStorage.getItem("jwtToken")){ //check if its valid, dont just wether it exists or not.
      this.router.navigate(['']);
    }
  }

  attemptLogin(username:String, password:String){
    if(!username || !password){
      this.loginerror="Please enter a username and password!";
    }else{
      const targetUrl = 'http://localhost:8080/auth/login';
      const body = {username,password};
      const headers = new HttpHeaders(
        {
            'Content-Type': 'application/json'
        });

      this.http.post(targetUrl,body,{headers:headers}).toPromise()
      .then(res=>{
          localStorage.setItem("jwtToken",res['message']);
          this.router.navigate(['']);
      })
      .catch(err=>{
        this.loginerror=err['error']['message']
      });
    }
  }
}
