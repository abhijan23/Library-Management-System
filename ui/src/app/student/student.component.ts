import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  title = "Student Management"
  // students = [    {     "id": 1,    "name": "Abhijan Mallick",    "department": "IT",     "rollNumber": "34",     "birthDate": "19-04-2002",      "mobileNumber": "983xxxxxx6"}]
  students: any = []

  isGreen = true

  constructor(private router : Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudents()
  }

  addStudent(){
    console.log("addStudent button clicked")
    this.router.navigateByUrl('/add-student')
  }

  fetchAllStudents(){
    this.http.get("http://localhost:8080/students/getAll")
    .subscribe(resp => {
      this.students=resp;
      console.log("Students retrieved successfully", this.students)
    }, error => {
      console.error('Error retrieving students:',error);
    });
  }

  deleteStudent(studentId: Number){
    const url = 'http://localhost:8080/students/delete/'+studentId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Student deleted successfully');
      this.fetchAllStudents()
    }, error => {
      console.error('Error in deleting Students', error);
    });
  }
}
