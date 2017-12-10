import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BaseLayoutComponent }  from './base-layout/base-layout.component';
import { LoginComponent }       from './authentication-module/login/login.component';
import { AuthService }          from './authentication-module/authservice/auth.service';
import { AccountViewComponent}  from './account-view-component/account-view-component.component';
import { HomepageComponent }    from './homepage-component/homepage-component.component';
import { SignupComponent }      from './authentication-module/signup/signup.component';
import { RequestsComponent }    from './requests/requests.component';
import { ServiceviewComponent } from './serviceview/serviceview.component';
import { ServiceviewFormComponent } from './serviceview-form/serviceview-form.component';
import { ServicedescriptionComponent } from './serviceview-description/serviceview-description.component';

const routes: Routes = [
  { path: '',component:BaseLayoutComponent, canActivate:[AuthService], 
    children:[
      { path:'',redirectTo:'homepage/1',pathMatch:'full'},
      { path:'homepage',redirectTo:'homepage/1',pathMatch:'full'},
      { path:'account', component:AccountViewComponent,pathMatch:'full'},
      { 
        path: 'homepage/:serviceid',component:HomepageComponent,
        children:[
          { path: '', redirectTo:'description',pathMatch:'full'},
          { path: 'request', component:ServiceviewFormComponent,pathMatch:'full'},
          { path: 'description', component:ServicedescriptionComponent,pathMatch:'full'},
        ]
      },
      { path: 'requests',component:RequestsComponent,pathMatch:'full'},
    ]},
  { path: 'login', component: LoginComponent,pathMatch: 'full'},
  { path: 'signup', component: SignupComponent,pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ enableTracing: false })],
  exports: [RouterModule],
  declarations: [],
})
export class AppRoutingModule {}
/*
        children:[
          {path:'',redirectTo:'1/description',pathMatch:'full'},
          { path: ':serviceid',
            component: ServiceviewComponent,
            children:[
              {path:'',redirectTo:'description',pathMatch:'full'},
              {path:'description',component:ServicedescriptionComponent,pathMatch:'full'},
              {path:'request',component:ServiceviewFormComponent,pathMatch:'full'}
            ], 
          }
        ]*/