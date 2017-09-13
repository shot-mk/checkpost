export class PassengerDriver {
	constructor(
		public passport?: number,
		public phone?: number
	) {	}
}

export class FormData {
	constructor(
		public manufacturer?: string,
		public plateNumber?: number,
		public location?: string,
		public destination?: string,
		public passengers?: PassengerDriver[],
		public driver?: PassengerDriver,
		public dateAndTime?: any,
		public color?: string,
		public checkpointName?: string
	) { }
}