import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserviceService } from '../patientservice.service';

@Component({
  selector: 'app-addpatient',
  templateUrl: './addpatient.component.html',
  styleUrls: ['./addpatient.component.css']
})
export class AddpatientComponent implements OnInit {
  
  patient =new Patient();
  constructor(private route:Router, private service:PatientserviceService) { }

  ngOnInit(): void {
  }
  addpatient(){
    this.service.addpatientremote(this.patient).subscribe(
      data=>{
        console.log("data added successfully");
        this.route.navigate(['patientlist']);
      },
      error=>console.log("error")
    )
  }
gotolist(){
  console.log("go back");
  this.route.navigate(['patientlist']);
}
}
