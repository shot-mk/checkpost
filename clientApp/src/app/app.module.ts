import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { MainService } from './services/main.service';

import { AppComponent } from './app.component';
import { CheckpostDetailsComponent } from './checkpost-details/checkpost-details.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { CheckpostsComponent } from './checkposts/checkposts.component';

import { AppRoutingModule } from './app-routing.module';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './services/in-memory-data.service';

import { DateTimePickerModule } from 'ng-pick-datetime';
import { DigitSequenceDirective } from './directives/digit-sequence.directive';

@NgModule({
  declarations: [
    AppComponent,
    CheckpostDetailsComponent,
    AddVehicleComponent,
    CheckpostsComponent,
    DigitSequenceDirective
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    DateTimePickerModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService)
  ],
  providers: [MainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
