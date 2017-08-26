import { Component } from '@angular/core';
import { MainService } from '../services/main.service';
import { CheckpostPanel } from '../classes/checkpost-panel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkposts',
  templateUrl: './checkposts.component.html',
  styleUrls: ['./checkposts.component.css']
})

export class CheckpostsComponent {

	data: any[];
	checkpostPanels: CheckpostPanel[];
	title: string = "Checkpost 0.1.ALPHA";
	selectedCheckpostPanel: CheckpostPanel;

  constructor (private mainService: MainService, private router: Router) {}

  ngOnInit(): void {
		//this.getData();
		this.getCheckpostPanels();
	}

  getData(): void {
  	this.mainService.getData().subscribe(response => {
			this.data = response;
			console.log(this.data);
		});
  }

  getCheckpostPanels(): void {
  	this.mainService.getCheckpostPanels().then(checkpostPanels => this.checkpostPanels = checkpostPanels);
  }

	onSelect(checkpostPanel): void {
		this.selectedCheckpostPanel = checkpostPanel;
	}

	goToAddVehicle(checkpostPanel: CheckpostPanel) {
		this.router.navigate(['/add', checkpostPanel.name, {editedCheckpost: checkpostPanel.name}]);
	}
}
