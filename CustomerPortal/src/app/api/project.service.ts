import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

import { Project } from '../project/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http:HttpClient) { }

  public getProjects(): Observable<Project[]> {
    const projWindmills: Project = {
      name: 'Glasvezelnetwerk in Californië',
      category: 'energy',
      description: 'Fullerton heeft een inwonertal van ongeveer 135.000. In de gemeente staan 50.000 woningen en 5.000 bedrijven. Het nieuwe glasvezelnetwerk zal over de gehele gemeente worden uitgerold.',
      progress: 647822,
      target: 800000
    };
    const projTollRoad: Project = {
      name: 'Finish the Finnish toll roads',
      category: 'infrastructure',
      description: 'Invest in toll roads for a better flow to Finland. Invest in toll roads for a better flow to Finland. Invest in toll roads for a better flow to Finland.',
      progress: 1234567,
      target: 3000000
    };

    return of([projWindmills, projTollRoad]).pipe(delay(2000));
  }
}
