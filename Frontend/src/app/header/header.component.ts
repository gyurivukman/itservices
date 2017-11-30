import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { AuthService } from '../authentication-module/authservice/auth.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {
  tabLinks = [
    {label: 'Home', link: '/homepage'},
    {label: 'Account', link: '/account'},
    {label: 'Requests', link: '/requests'},
    {label: 'Admin', link: ''},
  ];
  constructor(private authService:AuthService) {}

  ngOnInit() {
  }

  logout(){
    this.authService.logout();
  }
}
