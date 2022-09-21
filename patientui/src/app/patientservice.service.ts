import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientserviceService {

  dcodes:Array<String>
  constructor(private http:HttpClient) { }

  setdcodes(data:Array<String>){
    this.dcodes=data;
  }
  getdcodes(){
    return this.dcodes;
  }

  fetchPatientList():Observable<any>{
    return this.http.get<any>("http://localhost:8082/patients");
  }
  addpatientremote( patient:Patient):Observable<any>{
    return this.http.post<any>("http://localhost:8082/patients",patient);
  }
  updatepatientremote(patient:Patient,id:string):Observable<any>{
    return this.http.put<any>("http://localhost:8082/patients/"+id,patient);
  }
  fetchpatientbyid(id:string):Observable<any>{
    return this.http.get<any>("http://localhost:8082/patient/"+id);
  }
  deletepatientbyid(id:string):Observable<any>{
    return this.http.delete<any>("http://localhost:8082/patients/"+id);
  }
}
