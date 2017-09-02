import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JsonPipe } from '@angular/common';

import { Checkpost } from '../classes/checkpost';
import { CheckpostTest } from '../classes/checkpost-test';

import { Vehicle } from '../classes/vehicle';
import { Color } from '../classes/color';
import { Manufacturer } from '../classes/manufacturer';
import { District } from '../classes/district';
import { Passenger } from '../classes/passenger';
import { Location } from '../classes/location';
import { Destination } from '../classes/destination';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

	name: string;
	model: Checkpost;

	color: string;
	manufacturer: string;
	plateNumber: number;
	passengers: any = [{"passport": "", "phone": ""}];

  constructor(private activatedRoute: ActivatedRoute) {
  }

	ngOnInit() {
	  this.name = this.activatedRoute.snapshot.url[1].path;
	  //this.model = new Checkpost( 1, this.name );
	  //console.log(this.model);
	}

	onSubmit(vehicleForm) {
		// console.log(this.model);
		this.model = new Checkpost(
			1, // id
			this.name, // checkpost name
			new Vehicle( 2, new Color(2, this.color), this.plateNumber, new Manufacturer(3, this.manufacturer) )
		);
		console.log(this.passengers);
	}

	addPassenger(): void {
		this.passengers.push({"passport": "", "phone": ""});
	}

	deletePassenger(): void {
		this.passengers.splice(-1,1);
	}

	trackByFn(index) {
    return index;
  }

}