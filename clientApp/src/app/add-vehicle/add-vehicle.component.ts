import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

	name: string;
  private sub: any;

  constructor(private activatedRoute: ActivatedRoute) { }

	ngOnInit() {
	  this.sub = this.activatedRoute.params.subscribe(params => {
	     console.log(params);
	     this.name = params['editedCheckpost'];
	  });
	}

}