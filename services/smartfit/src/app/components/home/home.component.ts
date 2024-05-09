import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { FormComponent } from '../form/form.component';
import { LegendComponent } from '../legend/legend.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, FormComponent, LegendComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
