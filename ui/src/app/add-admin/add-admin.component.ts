import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent implements OnInit {
  adminForms : FormGroup;
  constructor(private formbuilder : FormBuilder, private http: HttpClient, private router: Router) {
    this.adminForms = this.formbuilder.group({
      name: ['',Validators.required],
      username: ['',Validators.required],
      password: ['',Validators.required] 
    })
   }

  ngOnInit(): void {
  }

  saveAdmin(){
    let adminData = this.adminForms.value;
    this.http.post('http://localhost:8080/admins/saveadmin',adminData)
    .subscribe(response => {
      console.log('Admin saved to DB', response)
      this.router.navigateByUrl('/admin')
    }, error =>{
      console.error('Error in admin save', error)
    }
    );
  }

}
