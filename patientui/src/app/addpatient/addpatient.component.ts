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
  dcodes=['K71.51','K50.013','I25.110','T81.535','T81.524','C50.212','H02.835','I80.01','L89.213','E11.311','S00-S09','Z47.81','L89.223'];
  patient =new Patient();
  constructor(private route:Router, private service:PatientserviceService) { }

  ngOnInit(): void {
    this.service.setdcodes(this.dcodes);
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
