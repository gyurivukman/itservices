import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BaseLayoutComponent }  from './base-layout/base-layout.component';
import { LoginComponent }       from './authentication-module/login/login.component';
import { AuthService }          from './authentication-module/authservice/auth.service';
import { AccountViewComponent}  from './account-view-component/account-view-component.component';
import { HomepageComponent }    from './homepage-component/homepage-component.component';
import { SignupComponent }      from './authentication-module/signup/signup.component';
import { RequestsComponent }    from './requests/requests.component';

const routes: Routes = [
  { path: '',component:BaseLayoutComponent, canActivate:[AuthService], 
    children:[
      {path:'',redirectTo:'homepage',pathMatch:'full'},
      { path: 'account', component:AccountViewComponent,pathMatch:'full'},
      { path: 'homepage',component:HomepageComponent,pathMatch:'full'},
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
