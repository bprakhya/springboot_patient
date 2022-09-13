import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddpatientComponent } from './addpatient/addpatient.component';
import { PatientlistComponent } from './patientlist/patientlist.component';
import { UpdatepatientComponent } from './updatepatient/updatepatient.component';
import { ViewpatientComponent } from './viewpatient/viewpatient.component';

const routes: Routes = [
  {path:'',component:PatientlistComponent},
  {path:'addpatient',component:AddpatientComponent},
  {path:'updatepatient/:id',component:UpdatepatientComponent},
  {path:'updatepatient',component:UpdatepatientComponent},
  {path:'viewpatient/:id',component:ViewpatientComponent},
  {path:'viewpatient',component:ViewpatientComponent},
  {path:'patientlist',component:PatientlistComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
