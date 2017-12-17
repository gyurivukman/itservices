import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { AuthenticationModule } from './authentication-module/authentication.module';
import { BaseLayoutComponent } from './base-layout/base-layout.component';
import { AppRoutingModule } from './app.routing';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage-component/homepage-component.component';
import { AccountViewComponent} from './account-view-component/account-view-component.component';

import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';

import { RequestsComponent } from './requests/requests.component';
import { ServiceviewComponent } from './serviceview/serviceview.component';
import { ServiceviewFormComponent } from './serviceview-form/serviceview-form.component';
import { ServicedescriptionComponent } from './serviceview-description/serviceview-description.component';

import {ServiceData_Service} from './serviceData-service/service-data.service';
import { AdminViewComponent } from './admin-view/admin-view.component';
import { OperatorViewComponent } from './operator-view/operator-view.component';

@NgModule({
  declarations: [
    AppComponent,
    BaseLayoutComponent,
    HeaderComponent,
    HomepageComponent,
    AccountViewComponent,
    RequestsComponent,
    ServiceviewComponent,
    ServiceviewFormComponent,
    ServicedescriptionComponent,
    AdminViewComponent,
    OperatorViewComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AuthenticationModule,
    MatCheckboxModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatTabsModule,
    MatListModule,
    MatCardModule,MatSelectModule,
    FormsModule,
    MatRadioModule,
    ReactiveFormsModule
  ],
  providers: [ServiceData_Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
