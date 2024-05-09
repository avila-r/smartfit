import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { FormComponent } from '../form/form.component';
import { LegendComponent } from '../legend/legend.component';
import { UnitsComponent } from '../units/units.component';
import { BehaviorSubject } from 'rxjs';
import { UnitsService } from '../../services/units.service';
import { Location } from '../../interfaces/location';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HeaderComponent, FormComponent, LegendComponent, UnitsComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  showList = new BehaviorSubject(false);
  units: Location[] = [];

  constructor(private unitsService: UnitsService){}

  submit(){
    this.units = this.unitsService.getFilteredUnits();
    this.showList.next(true);
  }
}