import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';
import { HomeComponent } from './home/home.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { AddBookComponent } from './add-book/add-book.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AdminComponent,
    AuthorComponent,
    LoanComponent,
    PublisherComponent,
    StudentComponent,
    HomeComponent,
    SidenavComponent,
    AddAdminComponent,
    AddAuthorComponent,
    AddBookComponent,
    AddLoanComponent,
    AddPublisherComponent,
    AddStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
