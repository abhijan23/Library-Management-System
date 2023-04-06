import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  title = "Author Management"
  // authors = [{      "id": 1,      "name": "Abhijan Mallick",      "birthdate": "19-04-2002",      "nationality":"Indian"}]
  authors: any = []

  isGreen = true

  constructor(private router : Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthors()
  }

  addAuthor(){
    console.log("addAuthor botton clicked")
    this.router.navigateByUrl('/add-author')
  }

  fetchAllAuthors(){
    this.http.get("http://localhost:8080/authors/getAll")
    .subscribe(resp => {
      this.authors=resp;
      console.log("Authors retrieved successfully", this.authors)
    }, error => {
      console.error('Error retrieving authors:', error);
    });
  }

  deleteAuthor(authorId: Number){
    const url = 'http://localhost:8080/authors/delete/'+authorId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Author deleted successfully');
      this.fetchAllAuthors()
    }, error => {
      console.error('Error in deleting Authors:',error)
    })
  }
}
