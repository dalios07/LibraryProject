import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Issue } from '../module/Issue';
import { CrudService } from '../service/crud.service';

@Component({
  selector: 'app-edit-issue',
  templateUrl: './edit-issue.component.html',
  styleUrls: ['./edit-issue.component.css']
})
export class EditIssueComponent implements OnInit{

  Issue: Issue=new  Issue();

  ngOnInit(): void {
    let id =this.route.snapshot.paramMap.get('id');
    if(id)
    this.loadById(+id);
      
  }
  
  constructor(@Inject('IssueCrudService') private IssueService: CrudService<Issue>,private router:Router,private route: ActivatedRoute){}

  submitForm(){
    
    this.IssueService.edit(this.Issue).subscribe(
     data=>{
        this.router.navigate(["issue"])
     },
     error=>{console.error(error);}
     
    )
  }
  loadById(id:number)
  {
    this.IssueService.getId(id).subscribe(
      data=>{
        this.Issue=data
        console.log(data)
     },
     error=>{console.error(error);}
    )
  }

}

