import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { FormGroup, FormControl, Validators} from '@angular/forms';




@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.scss']
})
export class PhoneComponent implements OnInit {

   clickCounter: number = 0;
   name: string = '';
   numberList: any;
   phoneNumber: string = '';
   config: any;

   form = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(7),Validators.maxLength(10),Validators.pattern("^[0-9]*$")
 
    ])
    
  });
  
  get f(){
    return this.form.controls;
  }
  
  submit(){
    console.log(this.form.value);

     this.getPhoneNumber();
  }
  


  constructor(private _http: HttpService) {
   this.config = {
      itemsPerPage: 5,
      currentPage: 1,
      totalItems: this.numberList
    };

   }

  ngOnInit() {
  }

   getPhoneNumber() {
 this._http.getPhoneNumber(this.phoneNumber).subscribe(data => {
      this.numberList = data
      console.log(this.numberList);
      
    }
  );  }

  countClick() {
    this.clickCounter += 1;
  }

  pageChanged(event){
    this.config.currentPage = event;
  }

}
