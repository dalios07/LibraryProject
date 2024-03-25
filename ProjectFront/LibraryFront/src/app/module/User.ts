import { Issue } from "./Issue";

export class User {
    id: number;
    name: string;
    email: string;
    phoneNumber: string;
    enabled: boolean;
    password: string;
    role:string ; 
    registrationDate: Date;
    issues: Issue[]; 
  }