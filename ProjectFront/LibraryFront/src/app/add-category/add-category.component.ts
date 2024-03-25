import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../module/category';
import { CrudService } from '../service/crud.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit{

  Category: Category=new  Category();

  ngOnInit(): void {
    let id =this.route.snapshot.paramMap.get('id');
    if(id)
    this.loadById(+id);
      
  }
  
  constructor(@Inject('CategoryCrudService') private CategoryService: CrudService<Category>,private router:Router,private route: ActivatedRoute){}

  submitForm(){
    
    this.CategoryService.add(this.Category).subscribe(
     data=>{
        this.router.navigate(["category"])
     },
     error=>{console.error(error);}
     
    )
  }
  loadById(id:number)
  {
    this.CategoryService.getId(id).subscribe(
      data=>{
        this.Category=data
     },
     error=>{console.error(error);}
    )
  }

}
