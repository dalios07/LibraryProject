import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Author } from '../module/Author';
import { CrudService } from '../service/crud.service';
import { BaseComponent } from '../base/base.component';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent extends BaseComponent<Author> implements OnInit{
  
  constructor(@Inject('AuthorCrudService')  AuthorService: CrudService<Author>, router:Router) {
    super(AuthorService, router,{url:"Author"});
  }

  
  ngOnInit() {
    this.loadData()
    
  }
}

