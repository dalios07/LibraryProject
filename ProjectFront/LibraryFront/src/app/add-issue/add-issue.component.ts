import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CrudService } from '../service/crud.service';
import { Issue } from '../module/Issue';

@Component({
  selector: 'app-add-issue',
  templateUrl: './add-issue.component.html',
  styleUrls: ['./add-issue.component.css']
})
export class AddIssueComponent {

  Issue: Issue=new  Issue();

  
  
  constructor(@Inject('IssueCrudService') private IssueService: CrudService<Issue>,private router:Router,private route: ActivatedRoute){}

  submitForm(){
    
    this.IssueService.add(this.Issue).subscribe(
     data=>{
        this.router.navigate(["issue"])
     },
     error=>{console.error(error);}
     
    )
  }
 
}

