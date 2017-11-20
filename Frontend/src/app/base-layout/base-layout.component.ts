import { Component, OnInit } from '@angular/core';
import { AuthService } from '../authentication/authservice/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'base-layout',
  templateUrl: './base-layout.component.html',
  styleUrls: ['./base-layout.component.css']
})
export class BaseLayoutComponent {

  constructor(private authService:AuthService,private router:Router) {}

  logout(){
    this.authService.logout();
  }
}
