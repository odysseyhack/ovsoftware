import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

import { Project } from '../project/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private projects: Project[] = [];

  constructor(private http:HttpClient) {
    this.initializeDummyProjects();
  }

  public getProjects(): Observable<Project[]> {
    return of(this.projects).pipe(delay(1000));
  }

  public makeProject(project: Project): void {
    this.projects.push(project);
  }

  private initializeDummyProjects(): void {
    const projWindmills: Project = {
      name: 'Windmills in Spain',
      description: 'Invest in green energy provided by the Spanish winds!',
      target: 800000
    };
    const projTollRoad: Project = {
      name: 'Finish the Finnish toll roads',
      description: 'Invest in toll roads for a better flow to Finland',
      target: 3000000
    };

    this.projects = [projWindmills, projTollRoad];
  }
}
