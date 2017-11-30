import { Component, OnInit,ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'base-layout',
  templateUrl: './base-layout.component.html',
  styleUrls: ['./base-layout.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class BaseLayoutComponent {
  constructor() {}
}
