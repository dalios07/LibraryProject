import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../module/User';
import { CrudService } from '../service/crud.service';
import { BaseComponent } from '../base/base.component';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent extends BaseComponent<User> implements OnInit {

  user=new User();
  constructor(@Inject('UserCrudService') private UserService: CrudService<User>, router:Router) {
    super(UserService, router,{url:"User"});
  }

  
  ngOnInit() {
    this.loadData()

    
  }
  
  Add(){
    
    this.UserService.add(this.user).subscribe(
     data=>{
      this.loadData();
     },
     error=>{console.error(error);}
     
    )
  }
  changeState(id:number,state:boolean)
  {
    this.UserService.getId(id).subscribe(
      data=>{
        this.user=data
        this.user.enabled=state;
        this.Add();
        
       
     },
     error=>{console.error(error);}
    )
    
    
  }
}
