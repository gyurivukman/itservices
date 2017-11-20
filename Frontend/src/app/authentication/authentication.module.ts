import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthService } from './authservice/auth.service'
import { RouterModule, Router, CanActivate } from '@angular/router';


@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  providers:[AuthService],
  exports: [
    LoginComponent
  ],
  declarations: [LoginComponent]
})
export class AuthenticationModule { }
