import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {
  loanForms : FormGroup;
  constructor(private formbuilder : FormBuilder, private http: HttpClient, private router: Router) {
    this.loanForms = this.formbuilder.group({
      bookId: [0,Validators.required],
      studentId: [0,Validators.required],
      checkoutDate: ['',Validators.required],
      dueDate: ['',Validators.required],
      returnDate: ['',Validators.required]
    })
   }

  ngOnInit(): void {
  }

  saveLoan(){
    let loanData = this.loanForms.value;
    this.http.post('http://localhost:8080/loans/saveloan',loanData)
    .subscribe(response => {
      console.log('Loan saved to DB', response)
      this.router.navigateByUrl('/loan')
    }, error =>{
      console.error('Error in loan save', error)
    }
    );
  }

}
