import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { ServiceData_Service} from '../serviceData-service/service-data.service';
import { Router,ActivatedRoute } from '@angular/router';
import { OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'homepage-component',
  templateUrl: './homepage-component.component.html',
  styleUrls: ['./homepage-component.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomepageComponent implements OnInit, OnDestroy {
  private serviceNames;
  private sub:Subscription;

  constructor(private serviceData_service:ServiceData_Service,private router:Router,private activatedRoute:ActivatedRoute) {}

  selectService(id:number){
    this.router.navigate(['services',id,this.activatedRoute.snapshot.children[0].url[0].path]);
  }

  ngOnInit() {
    this.sub = this.serviceData_service.getServiceNames().subscribe(
      res=>{
        this.serviceNames = res;
      },
      err=>{
        if(err['status']==401 || err['status']==403){
          localStorage.removeItem('jwtToken');
          this.router.navigate(['login']);
        }
      }
    );
  }
  
  ngOnDestroy(){
    this.sub.unsubscribe();
  }

}