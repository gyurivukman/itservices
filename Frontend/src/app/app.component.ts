import { Component,ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import {AppRoutingModule} from './app.routing';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class AppComponent {
  title = 'app';

  constructor(private router:Router){}
}
