import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-add-publisher',
  templateUrl: './add-publisher.component.html',
  styleUrls: ['./add-publisher.component.css']
})
export class AddPublisherComponent implements OnInit {
  publisherForms : FormGroup;
  constructor(private formbuilder : FormBuilder, private http: HttpClient, private router: Router) {
    this.publisherForms = this.formbuilder.group({
      name: ['',Validators.required],
      address: ['',Validators.required],
      phone: ['',Validators.required],
      email: ['']
    })
   }

  ngOnInit(): void {
  }

  savePublisher(){
    let publisherData = this.publisherForms.value;
    this.http.post('http://localhost:8080/publishers/savepublishers',publisherData)
    .subscribe(response => {
      console.log('Publisher saved to DB', response)
      this.router.navigateByUrl('/publisher')
    }, error => {
      console.error('Error in publisher save', error)
    }
    );
  }
}
