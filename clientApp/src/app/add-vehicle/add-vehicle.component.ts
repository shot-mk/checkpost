import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PassengerDriver, FormData } from '../classes/formData';
import { MainService } from '../services/main.service';
import { CheckpostPanel } from '../classes/checkpost-panel';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

	checkpostRouteName: string;
	formData: FormData;
	he: any;
	myValue: boolean = true;
	checkpostPanels: CheckpostPanel[];

  constructor(private activatedRoute: ActivatedRoute, private mainService: MainService) { }

	ngOnInit() {
	  this.checkpostRouteName = this.activatedRoute.snapshot.url[1].path;
		this.getCheckpostPanels();
  	this.formData = new FormData("", undefined, "", "", [], new PassengerDriver(), "", "", new CheckpostPanel());

	  this.he = {
        firstDayOfWeek: 0,
        dayNames: ["יום ראשון", "יום שני", "יום שלישי","יום רביעי", "יום ימישי", "יום שישי", "יום שבת"],
        dayNamesShort: ["א", "ב", "ג", "ד", "ה", "ו", "ש"],
        monthNames: ["ינואר", "פברואר", "מרץ", "אפריל", "מאי", "יוני", "יולי", "אוגוסט", "ספטמבר", "אוקטובר", "נובמבר", "דצמבר"],
        monthNamesShort: ["ינואר", "פברואר", "מרץ", "אפריל", "מאי", "יוני","יולי", "אוגוסט", "ספטמבר", "אוקטובר", "נובמבר", "דצמבר"]
    };
	}

	getCheckpostPanels(): void {
  	this.mainService.getCheckpostPanels().then(checkpostPanels => {
  		this.checkpostPanels = checkpostPanels;
  		
  		this.checkpostPanels.forEach( (checkpostPanel) => {
			  if(checkpostPanel.name == this.checkpostRouteName) {
			  	this.formData.checkpost = checkpostPanel;
			  } 
			});

  	});
  }

  compareFn(c1, c2): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
	}

	onSubmit(driverPassport, driverPhone, checkpostName) {
		
		// we allow the form to be submitted if either driver's passport or driver's phone is invalid,
		// however we do not want an invalid value to be transfered to backend, so we check the values
		// and set them to undefined if they are invalid
		if(driverPassport._control._status == "INVALID") { this.formData.driver.passport = undefined }
		if(driverPhone._control._status == "INVALID") { this.formData.driver.phone = undefined }
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