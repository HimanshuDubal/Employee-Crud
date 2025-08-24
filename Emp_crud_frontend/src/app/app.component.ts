import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog } from '@angular/material/dialog';
import { EmpAddEditComponent } from './emp-add-edit/emp-add-edit.component';
import { inject } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatToolbarModule, MatButtonModule,MatFormFieldModule,MatInputModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
 
  emplist: Employee[] = [];
  title = 'CrudAppDemo';

  constructor(
    private empAddEditDialog: MatDialog,
    private http: HttpClient
  ) {
    this.getAllEmployee()
  }
  openaddEditEmployee() {
    this.empAddEditDialog.open(EmpAddEditComponent)
  }
 

  getAllEmployee() {
    this.http.get<Employee[]>("http://localhost:8282/Employees").subscribe((res: Employee[]) => {
      this.emplist = res
    })

  }

}
export class Employee {
  id = ""
  fnm = ""
  lnm = ""
  email = ""
  dob = ""
  gender = ""
  education = ""
  company = ""
  exp = ""
  pkg = ""
}
