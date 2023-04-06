import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  title = "Loan Management"
  // loans = [{"id": 1, "bookId": 12345, "studentId": 34,"checkoutDate": "01-03-2021","dueDate": "15-09-2021","returnDate": "14-09-2021"}]
  loans: any = []

  isGreen = true

  constructor(private router : Router,  private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllLoan()
  }


  addLoan(){
    console.log("addLoan button clicked")
    this.router.navigateByUrl('/add-loan')
  }

  fetchAllLoan(){
    this.http.get("http://localhost:8080/loans/getAll")
    .subscribe(resp => {
      this.loans=resp;
      console.log("Loans retrieved successfully", this.loans)
    }, error => {
      console.error('Error retrieving loans', error);
    });
  }

  deleteLoan(loanId: Number){

    const url = 'http://localhost:8080/loans/delete/'+loanId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Loan deleted successfully')
      this.fetchAllLoan()
    }, error => {
      console.error('Error in deleting Loans', error);
    });
  }
}
