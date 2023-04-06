import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  title = "Publisher Management"
  // publishers = [    {     "id": 1,      "name": "Santanu Mondal",     "address": "Sector-5, Kolkata",     "phone": "8012721629",      "email": "sm123@gmail.com"}]
  publishers: any = []

  isGreen = true

  constructor(private router : Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublisher()
  }

  addPublisher(){
    console.log("addPublisher button clicked")
    this.router.navigateByUrl('/add-publisher')
  }

  fetchAllPublisher(){
    this.http.get("http://localhost:8080/publishers/getAll")
    .subscribe(resp => {
      this.publishers=resp;
      console.log("Publisher retrieved successfully", this.publishers)
    }, error => {
      console.error('Error retrieving publisher:', error);
    });
  }

  deletePublisher(publisherId: Number){
    const url = 'http://localhost:8080/publishers/delete/'+publisherId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Publisher deleted successfully')
      this.fetchAllPublisher()
    }, error => {
      console.error('Error in deleting Publisher:',error);
    });
  }
}
