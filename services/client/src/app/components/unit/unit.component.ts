import { Component, Input } from '@angular/core';
import { Location } from '../../interfaces/location';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-unit',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './unit.component.html',
  styleUrl: './unit.component.scss'
})
export class UnitComponent {
  @Input() card!: Location;
  constructor() { }
}