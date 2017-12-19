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
import { ServiceviewFormComponent }    from './serviceview-form/serviceview-form.component';
import { ServicedescriptionComponent } from './serviceview-description/serviceview-description.component';
import { AdminViewComponent }     from './admin-view/admin-view.component';
import { OperatorViewComponent }  from './operator-view/operator-view.component';
import { RequestViewComponent }   from './request-view/request-view.component'

const routes: Routes = [
  { path: '',component:BaseLayoutComponent, canActivate:[AuthService], 
    children:[
      { path:'',redirectTo:'services/1',pathMatch:'full'},
      { path:'services',redirectTo:'services/1',pathMatch:'full'},
      { path:'account', component:AccountViewComponent,pathMatch:'full'},
      { 
        path: 'services/:serviceid',component:HomepageComponent,
        children:[
          { path: '', redirectTo:'description',pathMatch:'full'},
          { path: 'request', component:ServiceviewFormComponent,pathMatch:'full'},
          { path: 'description', component:ServicedescriptionComponent,pathMatch:'full'},
        ]
      },
      { path: 'requests',component:RequestsComponent,pathMatch:'full'},
      { path: 'requests/:requestid',component:RequestViewComponent,pathMatch:'full'},
      { path: 'admin',component:AdminViewComponent,pathMatch:'full'},
      { path: 'operator',component:OperatorViewComponent,pathMatch:'full'},
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