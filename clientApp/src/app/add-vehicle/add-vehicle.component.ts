import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Checkpost } from '../classes/checkpost';
import { CheckpostTest } from '../classes/checkpost-test';

import { Vehicle } from '../classes/vehicle';
import { Color } from '../classes/color';
import { Manufacturer } from '../classes/manufacturer';
import { District } from '../classes/district';
import { Passenger } from '../classes/passenger';
import { Location } from '../classes/location';
import { Destination } from '../classes/destination';
import { PassengerDriver, FormData } from '../classes/formData';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

	name: string;
	model: Checkpost;

	// color: string;
	// manufacturer: string;
	// plateNumber: number;
	// location: string;
	// destination: string;
	// dateAndTime: any;
	// passengers: any = [{"passport": "", "phone": ""}];

	formData: FormData;
	he: any;

  constructor(private activatedRoute: ActivatedRoute) {
  	this.formData = new FormData("", undefined, "", "", [new PassengerDriver()], "", "");
  }

	ngOnInit() {
	  this.name = this.activatedRoute.snapshot.url[1].path;

	  this.he = {
        firstDayOfWeek: 0,
        dayNames: ["יום ראשון", "יום שני", "יום שלישי","יום רביעי", "יום ימישי", "יום שישי", "יום שבת"],
        dayNamesShort: ["א", "ב", "ג", "ד", "ה", "ו", "ש"],
        monthNames: [ "ינואר","פברואר","מרץ","אפריל","מאי","יוני","יולי","אוגוסט","ספטמבר","אוקטובר","נובמבר","דצמבר" ],
        monthNamesShort: [ "ינואר", "פברואר", "מרץ", "אפריל", "מאי", "יוני","יולי", "אוגוסט", "ספטמבר", "אוקטובר", "נובמבר", "דצמבר" ]
    };
	}

	onSubmit(vehicleForm) {
		console.log(this.formData);
	}

	addPassenger(): void {
		this.formData.passengers.push(new PassengerDriver());
	}

	deletePassenger(): void {
		this.formData.passengers.splice(-1,1);
	}

	trackByFn(index) {
    return index;
  }

}