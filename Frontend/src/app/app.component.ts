import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {AppRoutingModule} from './app.routing';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private router:Router){}
}
