import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { AddBookComponent } from './add-book/add-book.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  {
    path : 'book',
    component : BookComponent,
  },
  {
    path : 'admin',
    component : AdminComponent,
  },
  {
    path : 'author',
    component : AuthorComponent,
  },
  {
    path : 'loan',
    component : LoanComponent,
  },
  {
    path : 'publisher',
    component : PublisherComponent,
  },
  {
    path : 'student',
    component : StudentComponent,
  },
  {
    path : 'add-admin',
    component : AddAdminComponent,
  },
  {
    path : 'add-author',
    component : AddAuthorComponent,
  },
  {
    path : 'add-book',
    component : AddBookComponent,
  },
  {
    path : 'add-loan',
    component : AddLoanComponent,
  },
  {
    path : 'add-publisher',
    component : AddPublisherComponent,
  },
  {
    path : 'add-student',
    component : AddStudentComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
