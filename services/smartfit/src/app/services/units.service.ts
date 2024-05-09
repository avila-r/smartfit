import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Location } from '../interfaces/location';
import { HttpClient } from '@angular/common/http';
import { UnitsResponse } from '../interfaces/units-response';

const openingHours = {
  morning: { first: '06', last: '12' },
  afternoon: { first: '12', last: '18' },
  night: { first: '18', last: '23' }
}

type hourIndexes = 'morning' | 'afternoon' | 'night'

@Injectable({
  providedIn: 'root'
})
export class UnitsService {
  private url = "https://test-frontend-developer.s3.amazonaws.com/data/locations.json";
  private unitsSubject: BehaviorSubject<Location[]> = new BehaviorSubject<Location[]>([]);
  private units: Observable<Location[]> = this.unitsSubject.asObservable();
  private filteredUnits: Location[] = [];

  constructor(private http: HttpClient){
    this.http.get<UnitsResponse>(this.url).subscribe(
      data => {
        this.unitsSubject.next(data.locations);
        this.filteredUnits = data.locations;
      }
    )
  }

  getAllUnits(): Observable<Location[]>{
    return this.units;
  }

  getFilteredUnits(){
    return this.filteredUnits;
  }

  setFilter(filter: Location[]){
    this.filteredUnits = filter;
  }

  defineWeekday(day: number){
    switch (day){
      default: return 'Seg. à Sex.'
      case 6: return 'Sáb'
      case 0: return 'Dom.'
    }
  }

  filterUnits(unit: Location, opening: string, closing: string){
    if (!unit.schedules) return true;
    var openingHourFilter = parseInt(opening, 10);
    var closingHourFilter = parseInt(closing, 10);
    var weeyday = this.defineWeekday(new Date().getDay());

    for (let i = 0; i < unit.schedules.length; i++){
      var scheduleHour = unit.schedules[i].hour;
      var scheduleDay = unit.schedules[i].weekdays;
      if (weeyday === scheduleDay){
        if (scheduleHour !== 'Fechada'){
          var [unitOpeningHour, unitClosingHour] = scheduleHour.split(' às ');
          var unitOpeningHourInteger = parseInt(unitOpeningHour.replace('h', ''), 10);
          var unitClosingHourInteger = parseInt(unitClosingHour.replace('h', ''), 10);
          
          if (unitOpeningHourInteger <= openingHourFilter && unitClosingHourInteger <= closingHourFilter){
            return true;
          } else return false;
        }
      }
    }
    return false;
  }

  filter(results: Location[], showClosed: boolean, hour: string){
    if (!showClosed) results = results.filter(location => location.isOpened === true);
    if (hour) return results.filter(location => this.filterUnits(location, openingHours[hour as hourIndexes].first, openingHours[hour as hourIndexes].last))
      else return results;
  }
}