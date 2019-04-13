import { Component, Input } from '@angular/core';
import { Project } from './project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss'],
})
export class ProjectComponent {

  @Input() project: Project;

  constructor() { }

  public getIconForCategory(): string {
    if (this.project.category === 'energy') {
      return 'battery-charging';
    } else if(this.project.category === 'infrastructure') {
      return 'train'
    } else {
      return '';
    }
  }

}
