import { Component, OnInit } from '@angular/core';
import { Router, ActivationStart,NavigationEnd,ActivatedRoute} from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { ServiceData_Service } from '../serviceData-service/service-data.service';
import { NgForm } from '@angular/forms';
import { NgSwitch } from '@angular/common';

@Component({
  selector: 'app-serviceview-form',
  templateUrl: './serviceview-form.component.html',
  styleUrls: ['./serviceview-form.component.css']
})
export class ServiceviewFormComponent implements OnInit {
  serviceSub:Subscription;
  routerSub:Subscription;

  private serviceFormData;

  constructor(private service:ServiceData_Service,private router:Router,private route:ActivatedRoute) {
    let serviceid:number;
    
        this.route.parent.params.subscribe(params=>{
          serviceid = params['serviceid'];
        })
    
        this.routerSub = this.router.events.subscribe(event=>{
          if(event instanceof NavigationEnd){
            this.serviceSub=this.service.getServiceRequestForm(serviceid).subscribe(data=>{
              this.serviceFormData = JSON.parse(data['formdata']);
              console.log(this.serviceFormData);
            });
          }
        })
    
  }

  ngOnInit() {}
  ngOnDestroy(){
    this.routerSub.unsubscribe();
  }

  submitRequest(rf:NgForm){
    console.log(rf.value);
  }
}
