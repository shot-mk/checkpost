import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const checkpostPanels = [
      { id: 1, name: 'יהודה', vehicles: 146 },
	  { id: 2, name: 'בנימין', vehicles: 209 },
	  { id: 3, name: 'אפריים', vehicles: 156 },
	  { id: 4, name: '417', vehicles: 111 },
	  { id: 5, name: 'שומרון', vehicles: 99 },
	  { id: 6, name: 'עציון', vehicles: 65 },
	  { id: 7, name: 'מנשה', vehicles: 45 }
    ];
    return {checkpostPanels};
  }
}