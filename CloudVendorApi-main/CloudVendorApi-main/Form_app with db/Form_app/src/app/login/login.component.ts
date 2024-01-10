import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router, private http: HttpClient) { }

  user_records: any = [];
  data = {
    vendorName: "",
    vendorRollNumber: ""
  }

  post(data: any) {
    // console.log(data);
  }

  login() { 
    // console.log(this.data);
    this.http.get('http://localhost:8080/brimmaStudents').subscribe((data1) => {
      this.user_records = data1;
      // console.log(this.user_records);
      if (this.user_records.some((v: any) => {
        return v.vendorName == this.data.vendorName && v.vendorRollNumber == this.data.vendorRollNumber;
      })) {
        alert("Login Successful");
        this.router.navigate(['/data']);
      } else {
        alert("Login Failed");
      }
    });
  }
}
