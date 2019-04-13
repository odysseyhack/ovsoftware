import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';

import { ProjectService } from '../../app/api/project.service';
import { Project } from './project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  public projects$: Observable<Project[]>;

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.getProjects();
  }

  private getProjects(): void {
    this.projects$ = this.projectService.getProjects();
  }

}
