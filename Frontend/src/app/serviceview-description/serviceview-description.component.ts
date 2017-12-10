import { Component, OnInit,Input,AfterViewInit,OnChanges } from '@angular/core';
import { ActivatedRoute }                                  from '@angular/router';
import { ServiceData_Service }                             from '../serviceData-service/service-data.service';
import { Router }                                          from '@angular/router';
import { Subscription }                                    from 'rxjs/Subscription';
import { ActivationEnd }                                   from '@angular/router';
import { NavigationEnd }                                   from '@angular/router';
import { ActivationStart } from '@angular/router';

@Component({
  selector: 'app-servicedescription',
  templateUrl: './serviceview-description.component.html',
  styleUrls: ['./serviceview-description.component.css']
})
export class ServicedescriptionComponent implements OnInit{
  private description;
  private routerSub:Subscription;
  private serviceSub:Subscription;

  constructor(private service:ServiceData_Service, private router:Router, private route:ActivatedRoute) {
    let serviceid:number;
    
        this.route.parent.params.subscribe(params=>{
          serviceid = params['serviceid'];
        })
    
        this.routerSub = this.router.events.subscribe(event=>{
          if(event instanceof NavigationEnd){
            this.serviceSub=this.service.getServiceDescription(serviceid).subscribe(data=>{
              this.description = data['description'];
            });
          }
        })
    
  }

  ngOnInit() {}

  ngOnDestroy(){
    this.routerSub.unsubscribe();
    this.serviceSub.unsubscribe();
  }

}
