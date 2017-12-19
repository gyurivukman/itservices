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
  constructor(private reqService:RequestsService) { }

  ngOnInit() {
    this.reqServiceSub = this.reqService.getRequestsProperties().subscribe(
      (data)=>{
        if(data.length>0){
          console.log("Server válasza: ",data);
          console.log("parzattempt" ,JSON.parse(data[0].json_data));
        }       
      }
    );
  }

  ngOnDestroy(){
    this.reqServiceSub.unsubscribe();
  }
}
