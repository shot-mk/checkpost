import { Vehicle } from './vehicle';
import { District } from './district';
import { Passenger } from './passenger';
import { Location } from './location';
import { Destination } from './destination';

export class Checkpost {
	id: number;
	name: string;
	vehicle: Vehicle;
	district: District;
	passengers: Passenger[];
	location: Location;
	destination: Destination;
	date: string;
	time: string;
	dateCreated: string;
}
