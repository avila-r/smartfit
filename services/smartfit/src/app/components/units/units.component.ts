import { CommonModule } from '@angular/common';
import { Location } from '../../interfaces/location';
import { Component, Input } from '@angular/core';
import { UnitComponent } from '../unit/unit.component';

@Component({
  selector: 'app-units',
  standalone: true,
  imports: [UnitComponent, CommonModule],
  templateUrl: './units.component.html',
  styleUrl: './units.component.scss'
})
export class UnitsComponent {
  @Input() units: Location[] = [];
  constructor() { }
 }