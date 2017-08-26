import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-checkpost-details',
  templateUrl: './checkpost-details.component.html',
  styleUrls: ['./checkpost-details.component.css']
})
export class CheckpostDetailsComponent {

  @Input() checkpost: any;
  constructor() { }

}
