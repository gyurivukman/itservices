import { Component, OnInit } from '@angular/core';
import { Router, ActivationStart,NavigationEnd,ActivatedRoute} from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { ServiceData_Service } from '../serviceData-service/service-data.service';
import { NgForm } from '@angular/forms';
import { NgSwitch } from '@angular/common';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-serviceview-form',
  templateUrl: './serviceview-form.component.html',
  styleUrls: ['./serviceview-form.component.css']
})
export class ServiceviewFormComponent implements OnInit {
  serviceid:number;
  serviceSub:Subscription;
  routerSub:Subscription;

  private serviceFormData;

  constructor(private service:ServiceData_Service,public snackBar: MatSnackBar,
              private router:Router,private route:ActivatedRoute) {
    
    this.route.parent.params.subscribe(params=>{
      this.serviceid = params['serviceid'];
    })

    this.routerSub = this.router.events.subscribe(event=>{
      if(event instanceof NavigationEnd){
        this.serviceSub=this.service.getServiceRequestForm(this.serviceid).subscribe(data=>{
          this.serviceFormData = JSON.parse(data['formdata']);
        });
      }
    }) 
  }

  ngOnInit() {}

  ngOnDestroy(){
    this.routerSub.unsubscribe();
  }

  submitRequest(rf:NgForm){
    this.service.postServiceRequest(this.serviceid,rf.value).subscribe(res=>{
        this.snackBar.open('Your service request has been sent!', 'OK', {
          duration: 3000,
        });
        console.log(res);
        setTimeout(()=>{this.router.navigate(['/requests',res.id]);}, 2000);
      },err=>{
        console.log("Something bad happened! ",err);
      }
    );
  }
  
}