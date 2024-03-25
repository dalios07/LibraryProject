import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from '../module/authRequest';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  
  request= new AuthRequest();
  constructor(private authenticationService:AuthenticationService,private router:Router){}

  submitForm(){
    
    this.authenticationService.authenticate(this.request).subscribe(
     data=>{
      localStorage.setItem('jwtToken', data.jwtToken);
      window.location.reload()
      
     },
     error=>{console.error(error);}
     
    )
  }
}
