import { Component, OnInit,Input } from '@angular/core';
import { ActivatedRoute }    from '@angular/router';
import { ServiceData_Service } from '../serviceData-service/service-data.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { ResolveEnd } from '@angular/router';

@Component({
  selector: 'app-servicedescription',
  templateUrl: './servicedescription.component.html',
  styleUrls: ['./servicedescription.component.css']
})
export class ServicedescriptionComponent implements OnInit {
  private serviceid:number;
  private sub:Subscription;

  constructor(private service:ServiceData_Service,private router:Router) {
  }

  ngOnInit() {
    this.serviceid = this.service.getSelectedServiceData().id;
    this.sub = this.router.events.subscribe(event =>{
      if(event instanceof ResolveEnd){
        this.serviceid = this.service.getSelectedServiceData().id;
      }
    })
  }

  ngOnDestroy(){
    this.sub.unsubscribe();
  }
  
}
