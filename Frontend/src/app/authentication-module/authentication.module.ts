import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthService } from './authservice/auth.service'
import { RouterModule, Router, CanActivate } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
  ],
  providers:[AuthService],
  exports: [
    LoginComponent
  ],
  declarations: [LoginComponent, SignupComponent]
})
export class AuthenticationModule { }
