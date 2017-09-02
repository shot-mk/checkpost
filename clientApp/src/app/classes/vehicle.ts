import { Manufacturer } from './manufacturer';
import { Color } from './color';

export class Vehicle {
	constructor(
		public id: number,
		public color: Color,
		public plateNumber: number,
		public manufacturer: Manufacturer
	) { }
}