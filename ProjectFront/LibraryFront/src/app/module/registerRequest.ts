export class RegisterRequest {
    name: string;
    email: string;
    phoneNumber: string;
    password: string;
    role: number =1;
    enabled: boolean=true;
}
