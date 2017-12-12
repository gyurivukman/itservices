import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

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
  ];
  constructor(private authService:AuthService,private iconRegistry:MatIconRegistry,private sanitizer:DomSanitizer) {
    this.iconRegistry.addSvgIcon('logout',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/logout.svg'));
    if(this.userhasPermission()){
      this.tabLinks.push({label: 'Operator', link: '/operator'},{label: 'Admin', link: '/admin'});
    }
  }

  ngOnInit() {
  }

  logout(){
    this.authService.logout();
  }
  private userhasPermission():boolean{
    return false;
  }
}
