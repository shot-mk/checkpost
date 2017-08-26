import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { MainService } from './services/main.service';

import { AppComponent } from './app.component';
import { CheckpostDetailsComponent } from './checkpost-details/checkpost-details.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { CheckpostsComponent } from './checkposts/checkposts.component';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './services/in-memory-data.service';

const appRoutes: Routes = [
  { path: 'checkposts', component: CheckpostsComponent },
  { path: 'add/:id', component: AddVehicleComponent },
 
  { path: '',   redirectTo: '/checkposts', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    CheckpostDetailsComponent,
    AddVehicleComponent,
    CheckpostsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    InMemoryWebApiModule.forRoot(InMemoryDataService)
  ],
  providers: [MainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
