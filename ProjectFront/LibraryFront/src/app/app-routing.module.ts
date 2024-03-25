import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AuthorComponent } from './author/author.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { AddBookComponent } from './add-book/add-book.component';
import { BookComponent } from './book/book.component';
import { AddIssueComponent } from './add-issue/add-issue.component';
import { EditIssueComponent } from './edit-issue/edit-issue.component';
import { IssueComponent } from './issue/issue.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  {path:"category",component:CategoryComponent},
  {path:"addCategory",component:AddCategoryComponent},
  {path:"editCategory/:id",component:AddCategoryComponent},
  {path:"author",component:AuthorComponent},
  {path:"addAuthor",component:AddAuthorComponent},
  {path:"editAuthor/:id",component:AddAuthorComponent},
  {path:"Book",component:BookComponent},
  {path:"addBook",component:AddBookComponent},
  {path:"editBook/:id",component:AddBookComponent},
  {path:"issue",component:IssueComponent},
  {path:"addIssue",component:AddIssueComponent},
  {path:"editIssue/:id",component:EditIssueComponent},
  {path:"signup",component:SignUpComponent},
  {path:"signin",component:SignInComponent},
  {path:"student",component:StudentComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
