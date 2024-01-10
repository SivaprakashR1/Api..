import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent {

  user_input: any[] = [];
  form_data = {
    vendorName: '',
    vendorAddress: '',
    vendorPhoneNumber: '',
  };
  data:any = [];
  constructor(private http: HttpClient) {
    this.getdata();
  }
  getdata(){
    this.http.get('http://localhost:8080/brimmaStudents',).subscribe((data) =>{
    this.data = data;
  });

  }
}
