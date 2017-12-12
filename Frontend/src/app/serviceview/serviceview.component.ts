import { Component, OnInit, Input,ViewEncapsulation} from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ServiceData_Service } from '../serviceData-service/service-data.service';

@Component({
  selector: 'serviceview',
  templateUrl: './serviceview.component.html',
  styleUrls: ['./serviceview.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ServiceviewComponent implements OnInit {
  private tabLinks=[{label:'Description',link:'description'},{label:'Request',link:'request'}];

  constructor(private serviceData_service:ServiceData_Service) {
  }

  ngOnInit() {}

  ngOnChanges(){
  }

}
