import { Component, OnInit,OnDestroy } from '@angular/core';
import { RequestsService } from '../requests-service/requests-service.service';
import { Subscription } from 'rxjs/Subscription';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer }    from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Subscribable } from 'rxjs/Observable';

@Component({
  selector: 'app-request-view',
  templateUrl: './request-view.component.html',
  styleUrls: ['./request-view.component.css']
})
export class RequestViewComponent implements OnInit,OnDestroy {
  private reqServiceSub:Subscription;
  private routerSub:Subscription;
  private requestData;
  private iconReady:boolean = false;
  private averageResponsetime:number;
  private json_data;
  private json_keys;
  private activatedRequestID:number;

  constructor(private reqService:RequestsService,private iconRegistry:MatIconRegistry,
    private sanitizer:DomSanitizer,private route:ActivatedRoute) {
      this.json_keys=Object.keys
    }
  async ngOnInit() {
    
    this.routerSub=this.route.params.subscribe(params=>{
      this.reqServiceSub = this.reqService.getRequestData(params['requestid']).subscribe((res)=>{
        this.requestData = res;
        this.json_data = JSON.parse(res.json_data);
        this.averageResponsetime = res.requestedService.averageResponseTime/60000;
        this.iconRegistry.addSvgIcon('request-view-descripton-icon',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/'+res.requestedService.iconFileName+'.svg'));
        this.iconReady = true;
      });
    })
  }

  ngOnDestroy(){
    this.reqServiceSub.unsubscribe();
    this.routerSub.unsubscribe();
  }
}
