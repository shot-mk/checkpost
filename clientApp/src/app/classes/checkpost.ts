import { Vehicle } from './vehicle';
import { District } from './district';
import { Passenger } from './passenger';
import { Location } from './location';
import { Destination } from './destination';

export class Checkpost {
	constructor(
		public id: number,
		public name: string,
		public vehicle?: Vehicle,
		public district?: District,
		public passengers?: Passenger[],
		public location?: Location,
		public destination?: Destination,
		public date?: string,
		public time?: string,
		public dateCreated?: string
	) { }
}