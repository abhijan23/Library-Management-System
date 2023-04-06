import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title = "Admin Management"
  // admins = [    {     "id": 1,      "name": "Arindam Chakraborty",      "username": "ac_STCET",     "password": "ac@123"    },{     "id": 2,      "name": "Ranjit Ghosal",      "username": "rg_STCET",     "password": "rg@345"    }, {     "id": 3,      "name": "Gautam Banerjee",      "username": "gb_STCET",     "password": "gb@123"    }, {     "id": 4,      "name": "SK Latib",      "username": "sl_STCET",     "password": "sl@123"    }, {     "id": 5,      "name": "Amit D",      "username": "ad_STCET",     "password": "ad@123"    }]
  admins: any = []


  isGreen = true

  constructor(private router : Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAdmins()
  }

  addAdmin(){
    console.log("addAdmin button clicked")
    this.router.navigateByUrl('/add-admin')
  }

  fetchAllAdmins(){
    this.http.get("http://localhost:8080/admins/getAll")
    .subscribe(resp => {
      this.admins=resp;
      console.log("Admins retrieved successfully", this.admins)
    }, error => {
      console.error('Error retrieving admins:', error);
    });
  }

  deleteAdmin(adminId: Number){

    const url = 'http://localhost:8080/admins/delete/'+adminId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Admin deleted successfully');
      this.fetchAllAdmins()
    }, error => {
      console.error('Error in deleting Admins:', error);
    });
  }
}
