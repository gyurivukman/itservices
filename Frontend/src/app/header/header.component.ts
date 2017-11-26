import { Component, OnInit } from '@angular/core';
import { AuthService } from '../authentication-module/authservice/auth.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService:AuthService) {}

  ngOnInit() {
  }

  logout(){
    this.authService.logout();
  }
}
