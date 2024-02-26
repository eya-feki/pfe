import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';
import { Employee } from '../../model/employee';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { Gender } from '../../model/employee';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'] 
})
export class DashboardComponent implements OnInit {
onPhotoSelected($event: Event) {
throw new Error('Method not implemented.');
}
  empDetail!: FormGroup;
  empObj: Employee = new Employee();
  empList: Employee[] = [];
  genderOptions = Object.values(Gender); 
  selectedPhotoUrl: string = ''; // Declaring selectedPhotoUrl here
  employee: any;
  constructor(private formBuilder: FormBuilder, private empService: EmployeeServiceService) {}

  ngOnInit(): void {
    this.getAllEmployee();
    this.empDetail = this.formBuilder.group({
      id:[''],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      gender: ['', Validators.required],
      photo: ['']
    })
    
  }

  addEmployee() {
    console.log(this.empDetail);
    this.empObj.id = this.empDetail.value.id;
    this.empObj.firstname = this.empDetail.value.firstname;
    this.empObj.lastname = this.empDetail.value.lastname;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.gender = this.empDetail.value.gender; 
    this.empObj.photo = this.empDetail.value.photo;

    this.empService.addEmployee(this.empObj).subscribe(
        (res) => {
            console.log(res);
            this.getAllEmployee();
        },
        (err) => {
            console.log(err);
        }
    );
}


  getAllEmployee(): void {
    this.empService.getAllEmployee().subscribe(
      res => {
        this.empList = res;
      },
      err => {
        console.log("Error while fetching data.");
      }
    );
  }

  editEmployee(emp : Employee) {
    this.empDetail.controls['id'].setValue(emp.id);
    this.empDetail.controls['firstname'].setValue(emp.firstname);
    this.empDetail.controls['lastname'].setValue(emp.lastname);
    this.empDetail.controls['email'].setValue(emp.email);
    this.empDetail.controls['gender'].setValue(emp.gender);
    this.empDetail.controls['photo'].setValue(emp.photo);  }
  updateEmployee() {

    this.empObj.id = this.empDetail.value.id;
    this.empObj.firstname = this.empDetail.value.firstname;
    this.empObj.lastname = this.empDetail.value.lastname;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.gender = this.empDetail.value.gender;
    this.empObj.photo = this.empDetail.value.photo;
    this.empService.updateEmployee(this.empObj).subscribe(res=>{
      console.log(res);
      this.getAllEmployee();
    },err=>{
      console.log(err);
    })

  }
  deleteEmployee(emp : Employee) {

    this.empService.deleteEmployee(emp).subscribe(res=>{
      console.log(res);
      alert('Employee deleted successfully');
      this.getAllEmployee();
    },err => {
      console.log(err);
    });

  }
  onAddPhotoSelected(event: any) {
    const file: File = event.target.files[0];
    const reader = new FileReader();
  
    reader.onloadend = () => {
        // Check if reader.result is not null before setting the src attribute
        if (reader.result) {
            // Update the selected photo URL
            this.selectedPhotoUrl = reader.result as string;
        } else {
            console.error('Error: Selected photo is null.');
        }
    };
  
    if (file) {
        reader.readAsDataURL(file);
    }
}


  onEditPhotoSelected(event: any) {
    const file: File = event.target.files[0];
    const reader = new FileReader();
  
    reader.onloadend = () => {
      // Check if reader.result is not null before setting the src attribute
      if (reader.result) {
        const selectedPhotoElement = document.getElementById('editSelectedPhoto');
        if (selectedPhotoElement) {
          selectedPhotoElement.setAttribute('src', reader.result as string);
        } else {
          console.error('Error: Element with ID "editSelectedPhoto" not found.');
        }
      } else {
        console.error('Error: Selected photo is null.');
      }
    };
  
    if (file) {
      reader.readAsDataURL(file);
    }
  }

}
