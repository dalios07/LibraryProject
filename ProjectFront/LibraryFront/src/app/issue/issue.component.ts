import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../module/category';
import { CrudService } from '../service/crud.service';
import { BaseComponent } from '../base/base.component';
import { Issue } from '../module/Issue';
import { User } from '../module/User';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent extends BaseComponent<Issue> implements OnInit{
  token = localStorage.getItem('jwtToken');
  user :User;
  role:string;
  constructor(@Inject('IssueCrudService')  IssueService: CrudService<Issue>, private authenticationService:AuthenticationService,router:Router) {
    super(IssueService, router,{url:"Issue"});
  }
  
  ngOnInit() {
    this.loadData()
    this.getUser(this.token)
     
    
  }
  getUser(token:string)
  {
      this.authenticationService.getUser(token).subscribe(
        data=>{
          this.user=data;
          this.role=data.role
          
         },
         error=>{console.error(error);}
      )
  }
 
}

