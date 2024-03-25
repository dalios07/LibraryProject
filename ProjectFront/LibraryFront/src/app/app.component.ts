import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './module/User';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'LibraryFront';
  token = localStorage.getItem('jwtToken');
  user :User;
  role:string;
  constructor(private authenticationService:AuthenticationService,private router:Router){}

  ngOnInit(): void {
    if(this.token)
    {
      this.getUser(this.token)
      console.log(this.token)
    }
      
  }

  logout() {
    localStorage.removeItem('jwtToken');
    this.router.navigate(["signin"])
    window.location.reload();
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
