import { Component, Inject, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Book } from '../module/Book';
import { CrudService } from '../service/crud.service';
import { Category } from '../module/category';
import { Author } from '../module/Author';


@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit{

  Book: Book=new  Book();
  CategoryList:string[]
  AuthorList:string[]

  ngOnInit(): void {
    let id =this.route.snapshot.paramMap.get('id');
    if(id)
    this.loadById(+id);
    this.getCategoryList();
    this.getAuthorList();
      
  }
  
  constructor(@Inject('BookCrudService') private BookService: CrudService<Book>,
  @Inject('CategoryCrudService') private CategoryService: CrudService<Category>,
  @Inject('AuthorCrudService')  private AuthorService: CrudService<Category>,
  private router:Router,private route: ActivatedRoute){}

  submitForm(){
    
    this.BookService.add(this.Book).subscribe(
     data=>{
        this.router.navigate(["Book"])
     },
     error=>{console.error(this.Book);}
     
    )
  }
  loadById(id:number)
  {
    this.BookService.getId(id).subscribe(
      data=>{
        this.Book=data
     },
     error=>{console.error(error);}
    )
  }
  getCategoryList()
  {
    this.CategoryService.getAll(0,10,"id","asc").subscribe(
      (data=>
        {
          this.CategoryList=data.content
          .filter(category => category.status=="ACTIVATED")
          .map(category => category.name);
          
          console.log(this.CategoryList);
        }),
        (error=>{
          console.error(error);
          
        }))
  }
  getAuthorList()
  {
    this.AuthorService.getAll(0,10,"id","asc").subscribe(
      (data=>
        {
          this.AuthorList=data.content
          .map(author => author.name);
         
          
        }),
        (error=>{
          console.error(error);
          
        }))
  }

}

