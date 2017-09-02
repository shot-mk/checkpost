import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

	name: string;

  constructor(private activatedRoute: ActivatedRoute) { }

	ngOnInit() {
	  this.name = this.activatedRoute.snapshot.url[1].path;
	}

}