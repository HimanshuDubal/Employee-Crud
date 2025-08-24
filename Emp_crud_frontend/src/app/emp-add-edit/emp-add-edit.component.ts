import { Component } from '@angular/core';
import {
  MatDialogActions,
  MatDialogContent,
  MatDialogTitle} from '@angular/material/dialog';
  import {MatButtonModule} from '@angular/material/button';
  import {MatFormFieldModule} from '@angular/material/form-field';
  import {MatInputModule} from '@angular/material/input';
  import {MatDatepickerModule} from '@angular/material/datepicker';
  import { MatNativeDateModule, provideNativeDateAdapter } from '@angular/material/core';
  import {MatRadioModule} from '@angular/material/radio';
  import {MatSelectModule} from '@angular/material/select';
import { FormBuilder, FormGroup,Form,ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
  
  @Component({
  selector: 'app-emp-add-edit',
  standalone: true,
  providers:[provideNativeDateAdapter()],
  imports: [MatDialogActions,MatDialogContent,MatDialogTitle,MatButtonModule,MatFormFieldModule,MatInputModule,MatDatepickerModule,MatNativeDateModule,MatRadioModule,MatSelectModule,ReactiveFormsModule,FormsModule],
  templateUrl: './emp-add-edit.component.html',
  styleUrl: './emp-add-edit.component.css'
})
export class EmpAddEditComponent {
  empfromgroup:FormGroup
  employeelist:Employee[]=[]
  educationList:string[]=[
    "Matric",
    "Diploma",
    "Intermediate",
    "Graduate",
    "Post Graduate"
  ]
  constructor(private frmBldr:FormBuilder ,private http:HttpClient){
    this.empfromgroup=this.frmBldr.group({
      fnm:"",
      lnm:"",
      email:"",
      dob:"",
      gender:"",
      education:"",
      company:"",
      exp:"",
      pkg:""
    })
  }
  onFormSubmit(){
    this.saveEmployee()
    this.getALLEmployee()
  }
  getALLEmployee(){
    const url = "http://localhost:8282/Employees"
    this.http.get(url).subscribe((res:any)=>{
      this.employeelist=res as Employee[]
      for(let emp in res){
        console.log(res[emp])
      }
    })
  }
  saveEmployee(){
    const url = "http://localhost:8282/Employees"
    this.http.post(url,this.empfromgroup.value).subscribe((res:any)=>{
      console.log(res)
      alert('Saved successfully!');
      this.empfromgroup.reset();
      
    })
  }
}

class Employee{
  fnm="";
      lnm="";
      email="";
      dob="";
      gender="";
      education="";
      company="";
      exp="";
      pkg=""
}