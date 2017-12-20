import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AccountModifyService } from '../account-modify/account-modify.service';
import { Router } from '@angular/router';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTooltipModule } from '@angular/material';

@Component({
  selector: 'account-view-component',
  templateUrl: './account-view-component.component.html',
  styleUrls: ['./account-view-component.component.css']
})
export class AccountViewComponent implements OnInit {
  private modifyErrors;
  private data;
  private currentPasswordError;
  private originalUsername: String;

  constructor(private accountModifyService: AccountModifyService, private router: Router, private iconRegistry: MatIconRegistry, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.data = {};
    this.modifyErrors = {};
    this.iconRegistry.addSvgIcon('warning-triangle',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/warning.svg'));
    this.iconRegistry.addSvgIcon('information',this.sanitizer.bypassSecurityTrustResourceUrl('./assets/icons/information.svg'));
    this.attemptGetUser();
  }

  logout(){
    this.accountModifyService.logout();
  }

  doPasswordsMatch(pw1,pw2){
    return pw1===pw2 && pw1!=null && pw2!=null;
  }

  attemptGetUser() {
    this.accountModifyService.getUser().subscribe(
      res => {
        this.data = res;
        this.originalUsername = this.data.username;
      },
      err => {
        //this.loginerror = "Invalid username or password!";
      }
    )
  }

  private doModify(modifyForm: NgForm) {
    this.data.token = localStorage.getItem('jwtToken');
    if (modifyForm.value.username) this.data.username = modifyForm.value.username;
    this.data.password = modifyForm.value.password; // backend wont modify pw if empty
    if (modifyForm.value.forename) this.data.forename = modifyForm.value.forename;
    if (modifyForm.value.surname) this.data.surname = modifyForm.value.surname;
    this.accountModifyService.modify(this.data).subscribe(
      res => {

      },
      err => {
        this.modifyErrors = err.error;

        if(err.status == 200 && (this.originalUsername != modifyForm.value.username) && modifyForm.value.username != "") { // 200 OK
          this.logout(); // to avoid bugs (primarily because jwt is generated for username)
        } 
      }
    )
  }


  attemptModify(modifyForm: NgForm) {
    this.accountModifyService.login(this.originalUsername, modifyForm.value.currentpassword).subscribe(
      res => {
        this.currentPasswordError = null;
        this.doModify(modifyForm);
      },
      err => {
        this.currentPasswordError = "Invalid current password!";
      }
    )
  }
}
