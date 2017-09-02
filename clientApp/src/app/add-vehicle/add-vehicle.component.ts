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
	model: any;

  constructor(private activatedRoute: ActivatedRoute) {
  }

	ngOnInit() {
	  this.name = this.activatedRoute.snapshot.url[1].path;
	  this.model = new Checkpost(53, 'Dr IQ', new Vehicle(13, new Color(44, "crimson"), 3467599, new Manufacturer(99, "Nissan")));
	  console.log(this.model);
	}

	onSubmit(vehicleForm) {
		console.log(vehicleForm);
	}

}