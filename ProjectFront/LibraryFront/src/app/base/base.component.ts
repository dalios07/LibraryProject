import { Component } from '@angular/core';
import { CrudService } from '../service/crud.service';
import { Router } from '@angular/router';
import { Url } from '../module/Url';

@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.css']
})
export class BaseComponent<T> {
  List!:T[];
  searchvalue:string="";
  currentpage=0;
  paginationsize=8;
  nbOfPages=0;
  first=true;
  last=false;
  T!:T;
  constructor(protected genericService: CrudService<T>,protected router:Router,protected url:Url) {}

  loadData()
  {
    this.genericService.getAll(this.currentpage,this.paginationsize,"id","asc").subscribe(
      (data=>
        {
          this.List=data.content;
          this.nbOfPages=data.totalPages;
          this.first=data.first;
          this.last=data.last;
          console.log(this.List)
          
        }),
        (error=>{
          console.error(error);
          
        }))
  }

  Delete(id:Number)
  {
    this.genericService.delete(id).subscribe(
      (data=>
        {
          this.loadData();

        }),
        (error=>{
          console.error(error);
          
        })
    )
  }

  onSearchValueChange()
  {
      if(this.searchvalue=="")
        this.loadData();
      else
      this.genericService.search(this.searchvalue,this.currentpage,this.paginationsize,"name","asc").subscribe(
        (data=>
          {
            this.List=data.content;
          }),
          (error=>{
            console.error(error);
            
          })
      )

  }
  previousPage()
  {
    if(!this.first)
    {
      this.currentpage--;
      this.loadData();
    }
    
  }
  nextPage()
  {
    if(!this.last)
   {
    this.currentpage++;
    this.loadData();
   }
  }
  changePage(i:number)
  {
    this.currentpage=i-1;
    this.loadData();
  }
  getRange(nb: number): number[] {
    return Array(nb).fill(0).map((x, i) => i+1);}

    Navigate()
  {
      this.router.navigate(["add"+this.url.url]);
  }
  Navigate1(id:number)
  {
      this.router.navigate(["edit"+this.url.url,id]);
  }

  

}
