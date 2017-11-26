import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthService } from './authservice/auth.service'
import { RouterModule, Router, CanActivate } from '@angular/router';
import { RegistrationFormComponent } from './registration-form/registration-form.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers:[AuthService],
  exports: [
    LoginComponent
  ],
  declarations: [LoginComponent, RegistrationFormComponent]
})
export class AuthenticationModule { }
