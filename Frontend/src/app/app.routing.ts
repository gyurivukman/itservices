import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BaseLayoutComponent }  from './base-layout/base-layout.component';
import { LoginComponent }       from './authentication/login/login.component';
import { AuthService }          from './authentication/authservice/auth.service';

const routes: Routes = [
  { path: '',component:BaseLayoutComponent, pathMatch: 'full', canActivate:[AuthService]},
  { path: 'login',component:LoginComponent,pathMatch: 'full'}
  /*
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent },
  { path: 'heroes', component: HeroesComponent }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ enableTracing: false })],
  exports: [RouterModule],
  declarations: [],
})
export class AppRoutingModule {}
