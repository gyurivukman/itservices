import { Component, OnInit,Input,AfterViewInit,OnChanges,ViewEncapsulation }    from '@angular/core';
import { ActivatedRoute,Router,NavigationEnd }                                  from '@angular/router';
import { ServiceData_Service }                             from '../serviceData-service/service-data.service';
import { Subscription }                                    from 'rxjs/Subscription';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer }    from '@angular/platform-browser';

@Component({
  selector: 'app-servicedescription',
  templateUrl: './serviceview-description.component.html',
  styleUrls: ['./serviceview-description.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class ServicedescriptionComponent implements OnInit{
  private data;
  private responseTime;
  private iconReady:boolean = false;
  private routerSub:Subscription;
  private serviceSub:Subscription;

  constructor(private service:ServiceData_Service, 
              private router:Router, 
              private route:ActivatedRoute,
              private iconRegistry:MatIconRegistry,
              private sanitizer:DomSanitizer) {
    let serviceid:number;
    
      this.route.parent.params.subscribe(params=>{
        serviceid = params['serviceid'];
        this.iconReady = false;
      })
      
      this.routerSub = this.router.events.subscribe(event=>{
        if(event instanceof NavigationEnd){
          this.serviceSub = this.service.getServiceDescription(serviceid).subscribe(data =>{
            this.data = data;
            this.responseTime = (data['averageResponsetime'])/60000;
            this.iconRegistry.addSvgIcon('description-icon',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/'+data['iconFileName']+'.svg'));
            this.iconReady = true;
          })
        }
      })
  }

  ngOnInit() {
    
  }

  ngOnDestroy(){
    this.routerSub.unsubscribe();
    this.serviceSub.unsubscribe();
  }

}
