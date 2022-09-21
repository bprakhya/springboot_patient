import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserviceService } from '../patientservice.service';

@Component({
  selector: 'app-updatepatient',
  templateUrl: './updatepatient.component.html',
  styleUrls: ['./updatepatient.component.css']
})
export class UpdatepatientComponent implements OnInit {

  dcodes:Array<String>;
  patient =new Patient();
  constructor(private route:Router, private service:PatientserviceService,private activatedr:ActivatedRoute) { }

  ngOnInit(): void {
    this.dcodes=this.service.getdcodes();
    let id=this.activatedr.snapshot.paramMap.get('id');
    if(id!=null){
    this.service.fetchpatientbyid(id).subscribe(
      data=>{
        console.log("updated patient");
        this.patient=data;
      },
      error=>console.log("error in update")
    )}
  }
  updatepatient(){
    let id=this.activatedr.snapshot.paramMap.get('id');
    if(id!=null){
    this.service.updatepatientremote(this.patient,id).subscribe(
      data=>{
        console.log("data added successfully");
        this.route.navigate(['patientlist']);
      },
      error=>console.log("error")
    )}
  }
gotolist(){
  console.log("go back");
  this.route.navigate(['patientlist']);
}

}
