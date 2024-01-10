// import { Component } from '@angular/core';
// import { MatFormFieldModule } from '@angular/material/form-field';
// import { MatInputModule } from '@angular/material/input';
// import { getMatFormFieldDuplicatedHintError } from '@angular/material/form-field';
// import { FormControl, FormGroup,Validators } from '@angular/forms';
// import { UserService } from '../user.service';
// import { HttpClient } from '@angular/common/http';

// @Component({
//   selector: 'app-register',
//   templateUrl: './register.component.html',
//   styleUrls: ['./register.component.css']
// })
// export class RegisterComponent {
//   user_input: any[] = [];
//   form_data:any = {
//     vendorName: '',
//     vendorRollNumber: '',
//     vendorEmail: '',
//     vendorDepartment: ''
//   };

//   data:any = [];
//   constructor(private http: HttpClient) {
//     this.getdata();
//   }


//   getdata(){
//     this.http.get('http://localhost:8080/brimmaStudents',).subscribe((data) =>{
//     this.data = data;
    
//   });
// }
  
//   doRegister(form_data: any) { 
//     alert("Submited successfully");
//     this.http.post('http://localhost:8080/brimmaStudents',form_data).subscribe(
//       (response: any) => {
//         console.log('Data posted successfully:', response);
//       },

//     );
//   }
  

// }
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  form_data: any = {
    vendorName: '',
    vendorRollNumber: '',
    vendorEmail:'' ,
    vendorDepartment: ''
  };

  data2: any = [];

  myForm: FormGroup;

  constructor(private http: HttpClient,private fb: FormBuilder) {
    this.getdata();
  
    this.myForm = new FormGroup({
      vendorName: new FormControl(this.form_data.vendorName, [Validators.required]),
      vendorRollNumber: new FormControl(this.form_data.vendorRollNumber, [Validators.required]),
      vendorEmail: new FormControl(this.form_data.vendorEmail, [Validators.email]),
      vendorDepartment: new FormControl(this.form_data.vendorDepartment, [Validators.required])
    });
  }
  

  getdata() {
    this.http.get('http://localhost:8080/brimmaStudents').subscribe((data) => {
      this.data2 = data;
    });
  }

  doRegister(form_data: any) {
    if (this.myForm) {
      alert("Submitted successfully");
      this.http.post('http://localhost:8080/brimmaStudents', form_data).subscribe(
        (response: any) => {
          console.log('Data posted successfully:', response);
        },
        (error: any) => {
          console.error('Error posting data:', error);
        }
      );
    } else {
      alert("Please fill in all required fields.");
    }
  }

  // getErrorMessage() {
  //   if (this.email.hasError('required')) {
  //     return 'You must enter a value';
  //   }
  //   return this.email.hasError('email') ? 'Not a valid email' : '';
  // }
}
