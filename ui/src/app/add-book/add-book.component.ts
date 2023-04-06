import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  bookForms : FormGroup;
  constructor(private formbuilder : FormBuilder, private http: HttpClient, private router : Router) { 
    this.bookForms = this.formbuilder.group({
      title: ['',Validators.required],
      author: [ ,Validators.required],
      isbn: [ ,Validators.required],
      publicationdate: [ ,Validators.required],
      publisher: [ ,Validators.required],
      copies:[0,Validators.required],
      category: [ ,Validators.required],
      genre: [ ,Validators.required],
      subgenre: [ ,Validators.required]
    })
  }

  ngOnInit(): void {
  }

  saveBook(){
    //Make Post Call to Request URL http://localhost:8080/books/saveBook
    let bookData = this.bookForms.value;
    //Handle date to string
    this.http.post('http://localhost:8080/books/saveBook',bookData)
    .subscribe(response => {
      console.log('Book saved to DB', response)
      this.router.navigateByUrl('/book')
    }, error =>{
      console.error("Error in book save",error)
    }
    );
  }
}
