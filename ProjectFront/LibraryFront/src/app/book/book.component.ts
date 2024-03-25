import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from '../service/crud.service';
import { Book } from '../module/Book';
import { BaseComponent } from '../base/base.component';
import { User } from '../module/User';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent extends BaseComponent<Book> implements OnInit{
  token = localStorage.getItem('jwtToken');
  user :User;
  role:string;
  constructor(@Inject('BookCrudService')  BookService: CrudService<Book>, private authenticationService:AuthenticationService,router:Router) {
    super(BookService, router,{url:"Book"});
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
