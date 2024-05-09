import { Component, Output, signal, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { UnitsService } from '../../services/units.service';
import { Location } from '../../interfaces/location';
import { NONE_TYPE } from '@angular/compiler';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss'
})
export class FormComponent {
  form!: FormGroup;
  results: Location[] = [];
  filteredResults: Location[] = [];
  loading = signal(false);
  @Output("submit") submit = new EventEmitter();

  constructor(private service: UnitsService, private formBuilder: FormBuilder){
    this.form = this.formBuilder.group(
      {
        hour: '',
        showClosed: true
      }
    )
    this.service.getAllUnits().subscribe(
      data => {
        this.results = data;
      }
    )
  }

  private setFilterData(){
    this.filteredResults = this.results;
  }

  private resetFilterData(){
    this.filteredResults = [];
  }


  onSubmit(): void {
    var { showClosed, hour } = this.form.value;
    this.setFilterData();
    this.filteredResults = this.service.filter(this.results, showClosed, hour);
    this.service.setFilter(this.filteredResults);
    this.submit.emit();
  }

  onClean(){
    this.resetFilterData();
    this.form.reset();
  }
}