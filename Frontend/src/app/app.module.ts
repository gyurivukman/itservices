import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { AuthenticationModule } from './authentication-module/authentication.module';
import { BaseLayoutComponent } from './base-layout/base-layout.component';
import { AppRoutingModule } from './app.routing';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage-component/homepage-component.component';
import { AccountViewComponent} from './account-view-component/account-view-component.component';

import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { RequestsComponent } from './requests/requests.component';



@NgModule({
  declarations: [
    AppComponent,
    BaseLayoutComponent,
    HeaderComponent,
    HomepageComponent,
    AccountViewComponent,
    RequestsComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AuthenticationModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
