import { Component } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { RegisterRequest } from '../module/registerRequest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  request= new RegisterRequest();
  constructor(private authenticationService:AuthenticationService,private router:Router){}

  submitForm(){
    
    this.authenticationService.add(this.request).subscribe(
     data=>{
        this.router.navigate(["signin"])
     },
     error=>{console.error(error);}
     
    )
  }
}
