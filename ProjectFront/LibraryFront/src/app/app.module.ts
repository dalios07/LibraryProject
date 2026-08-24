import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryComponent } from './category/category.component';
import { CrudService } from './service/crud.service';
import { Category } from './module/category';
import { AddCategoryComponent } from './add-category/add-category.component';
import { FormsModule } from '@angular/forms';
import { AuthorComponent } from './author/author.component';
import { Author } from './module/Author';
import { AddAuthorComponent } from './add-author/add-author.component';
import { BookComponent } from './book/book.component';
import { AddBookComponent } from './add-book/add-book.component';
import { Book } from './module/Book';
import { AddIssueComponent } from './add-issue/add-issue.component';
import { IssueComponent } from './issue/issue.component';
import { EditIssueComponent } from './edit-issue/edit-issue.component';
import { Issue } from './module/Issue';
import { BaseComponent } from './base/base.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { DropdownModule } from 'primeng/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StudentComponent } from './student/student.component';
import { User } from './module/User';
import { environment } from '../environments/environment';



@NgModule({
  declarations: [
    AppComponent,
    CategoryComponent,
    AddCategoryComponent,
    AuthorComponent,
    AddAuthorComponent,
    BookComponent,
    AddBookComponent,
    AddIssueComponent,
    IssueComponent,
    EditIssueComponent,
    BaseComponent,
    SignUpComponent,
    SignInComponent,
    StudentComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    DropdownModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide:'CategoryCrudService',
      useFactory: (http: HttpClient) => {
        return new CrudService<Category>(http,{url:`${environment.apiUrl}/Category`});
      },
      deps: [HttpClient]
    },
    {
      provide:'AuthorCrudService',
      useFactory: (http: HttpClient) => {
        return new CrudService<Author>(http,{url:`${environment.apiUrl}/Author`});
      },
      deps: [HttpClient]
    },
    {
      provide:'BookCrudService',
      useFactory: (http: HttpClient) => {
        return new CrudService<Book>(http,{url:`${environment.apiUrl}/Book`});
      },
      deps: [HttpClient]
    },
    {
      provide:'IssueCrudService',
      useFactory: (http: HttpClient) => {
        return new CrudService<Issue>(http,{url:`${environment.apiUrl}/Issue`});
      },
      deps: [HttpClient]
    },
    {
      provide:'UserCrudService',
      useFactory: (http: HttpClient) => {
        return new CrudService<User>(http,{url:`${environment.apiUrl}/user`});
      },
      deps: [HttpClient]
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
