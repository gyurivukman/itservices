import { Injectable } from '@angular/core';
import { Router } from '@angular/router/';

@Injectable()
export class ServiceData_Service {
  private serviceData;
  private selectedServiceIndex:number;

  constructor(private router:Router) {
    this.serviceData =[
      {id:1,name:'service1',description:'egy'},
      {id:2,name:'service2',description:'ketto'},
    ];
    this.selectedServiceIndex = 0;
  }

  getServiceData(){
    return this.serviceData;
  }

  getSelectedServiceData(){
    return this.serviceData[this.selectedServiceIndex];
  }

  setSelectedService(index:number){
    this.selectedServiceIndex=index;
  }

  getServiceNames(){
    return this.serviceData.map(data=>data.name) ;
  }

}
