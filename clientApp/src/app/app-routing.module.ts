import { NgModule }              from '@angular/core';
import { RouterModule, Routes }  from '@angular/router';
 
import { CheckpostsComponent }   from './checkposts/checkposts.component';
import { AddVehicleComponent }     from './add-vehicle/add-vehicle.component';
 
const appRoutes: Routes = [
  { path: 'checkposts', component: CheckpostsComponent },
  { path: 'add/:name', component: AddVehicleComponent },
 
  { path: '',   redirectTo: '/checkposts', pathMatch: 'full' }
];
 
@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}