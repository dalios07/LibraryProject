import { Component, Inject, OnInit } from '@angular/core';
import { Category } from '../module/category';
import { CrudService } from '../service/crud.service';
import { Router } from '@angular/router';
import { BaseComponent } from '../base/base.component';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent extends BaseComponent<Category> implements OnInit{
  
  constructor(@Inject('CategoryCrudService')  CategoryService: CrudService<Category>, router:Router) {
    super(CategoryService, router,{url:"Category"});
  }

  
  ngOnInit() {
    this.loadData()
    
  }
}