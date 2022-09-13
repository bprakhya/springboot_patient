import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserviceService } from '../patientservice.service';

@Component({
  selector: 'app-viewpatient',
  templateUrl: './viewpatient.component.html',
  styleUrls: ['./viewpatient.component.css']
})
export class ViewpatientComponent implements OnInit {

  patient =new Patient();
  constructor(private route:Router, private service:PatientserviceService,private activatedr:ActivatedRoute) { }

  ngOnInit(): void {
    let id=this.activatedr.snapshot.paramMap.get('id');
    if(id !=null){
    this.service.fetchpatientbyid(id).subscribe(
      data=>{
        console.log("updated patient");
        this.patient=data;
      },
      error=>console.log("error in update")
    )}
    else{
      console.log("no id found");
    }
  }
gotolist(){
  console.log("go back");
  this.route.navigate(['patientlist']);
}

}

