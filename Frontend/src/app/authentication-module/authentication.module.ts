import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthService } from './authservice/auth.service'
import { RouterModule, Router, CanActivate } from '@angular/router';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule
  ],
  providers:[AuthService],
  exports: [
    LoginComponent
  ],
  declarations: [LoginComponent, RegistrationFormComponent]
})
export class AuthenticationModule { }
