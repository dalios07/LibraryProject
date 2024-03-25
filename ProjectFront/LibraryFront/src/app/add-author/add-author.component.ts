import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Author } from '../module/Author';
import { CrudService } from '../service/crud.service';

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit{

  Author: Author=new  Author();

  ngOnInit(): void {
    let id =this.route.snapshot.paramMap.get('id');
    if(id)
    this.loadById(+id);
      
  }
  
  constructor(@Inject('AuthorCrudService') private AuthorService: CrudService<Author>,private router:Router,private route: ActivatedRoute){}

  submitForm(){
    
    this.AuthorService.add(this.Author).subscribe(
     data=>{
        this.router.navigate(["author"])
     },
     error=>{console.error(error);}
     
    )
  }
  loadById(id:number)
  {
    this.AuthorService.getId(id).subscribe(
      data=>{
        this.Author=data
     },
     error=>{console.error(error);}
    )
  }
  

}
