import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddpatientComponent } from './addpatient/addpatient.component';
import { PatientlistComponent } from './patientlist/patientlist.component';
import { UpdatepatientComponent } from './updatepatient/updatepatient.component';
import { ViewpatientComponent } from './viewpatient/viewpatient.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddpatientComponent,
    PatientlistComponent,
    UpdatepatientComponent,
    ViewpatientComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
