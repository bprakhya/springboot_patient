import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserviceService } from '../patientservice.service';

@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patientlist.component.css']
})
export class PatientlistComponent implements OnInit {

  patient_list :Array<Patient>=[];
  constructor(private service:PatientserviceService,private route:Router) { }

  ngOnInit(): void {
    this.getPatients();
  }
  getPatients(){
    this.service.fetchPatientList().subscribe(
      data=>this.patient_list=data,
      error=>console.log("error")
    )
  }
  isEmpty(){
    if(this.patient_list==null){
      return true;
    }
    else{
      return false;
    }
  }
  addPatient(){
    this.route.navigate(['/addpatient']);
  }
  updatePatient(id:string){
    console.log("id:"+id);
    this.route.navigate(['/updatepatient',id]);
  }
  viewPatient(id:string){
    console.log("id:"+id);
    this.route.navigate(['/viewpatient',id]);
  }
  deletePatient(id :string){
    return this.service.deletepatientbyid(id).subscribe(
      data=>{
        console.log("deleted");
        this.getPatients();
      },
      error=>console.log("error")
    )
  }


}
