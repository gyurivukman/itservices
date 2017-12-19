import { Component, OnInit,OnDestroy } from '@angular/core';
import { RequestsService }   from '../requests-service/requests-service.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  private reqServiceSub:Subscription
  private requestMetadata;
  constructor(private reqService:RequestsService) {}
  ngOnInit() {
    this.reqServiceSub = this.reqService.getRequestsMetadata().subscribe(
      (data)=>{
        if(data.length>0){
          this.requestMetadata = data;
        }      
      }
    );
  }

  ngOnDestroy(){
    this.reqServiceSub.unsubscribe();
  }
}
