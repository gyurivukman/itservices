import { Component, OnInit } from '@angular/core';
import { ServiceData_Service} from '../serviceData-service/service-data.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'homepage-component',
  templateUrl: './homepage-component.component.html',
  styleUrls: ['./homepage-component.component.css']
})
export class HomepageComponent implements OnInit {
  private serviceNames;
  private selectedServiceData;

  constructor(private serviceData_service:ServiceData_Service,private router:Router,private activatedRoute:ActivatedRoute) {
    this.serviceNames = this.serviceData_service.getServiceNames();
    this.selectedServiceData = this.serviceData_service.getSelectedServiceData();
  }

  selectService(index){
    this.serviceData_service.setSelectedService(index);
    this.router.navigate(['homepage',index+1,this.activatedRoute.snapshot.children[0].url[0].path]);
  }

  ngOnInit() {
  }

}