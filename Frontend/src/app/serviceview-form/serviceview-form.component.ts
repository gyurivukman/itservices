import { Component, OnInit } from '@angular/core';
import { Router, ActivationStart }    from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {ServiceData_Service} from '../serviceData-service/service-data.service';

@Component({
  selector: 'app-serviceview-form',
  templateUrl: './serviceview-form.component.html',
  styleUrls: ['./serviceview-form.component.css']
})
export class ServiceviewFormComponent implements OnInit {
  private sub:Subscription;
  private serviceid;

  constructor(private service:ServiceData_Service,private router:Router) {
    this.serviceid = this.service.getSelectedServiceData().id;
    this.sub = this.router.events.subscribe(event =>{
      if(event instanceof ActivationStart){
        this.serviceid = this.service.getSelectedServiceData().id;
      }
    })
  }

  ngOnInit() {
  }

ngOnDestroy(){
  this.sub.unsubscribe();
}

}
