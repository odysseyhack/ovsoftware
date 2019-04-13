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
    const projGlassCali: Project = {
      name: 'Glasvezelnetwerk in Californië',
      category: 'infrastructure',
      icon: 'kubussen',
      image: 'cali',
      avatars: ['trump', 'musk', 'zuckerberg'],
      description: 'Fullerton heeft een inwonertal van ongeveer 135.000. In de gemeente staan 50.000 woningen en 5.000 bedrijven. Het nieuwe glasvezelnetwerk zal over de gehele gemeente worden uitgerold.',
      progress: 647822,
      target: 800000
    };
    const projLedLights: Project = {
      name: 'LED lampen in straatverlichting',
      category: 'city',
      icon: 'stad',
      image: 'led',
      avatars: ['merkel', 'poetin', 'rutte'],
      description: 'Streetlight 11 provides efficient street lighting with low energy costs and best environmental protection.By 2020, the city of Sulzbach - Rosenberg plans to convert 90 percent of its public lighting to LED.',
      progress: 98231,
      target: 250000
    };
    const projAirDrop: Project = {
      name: 'Medisch vervoer via de lucht',
      category: 'health',
      icon: 'hartslag',
      image: 'medic',
      avatars: ['machiel', 'thomas', 'tom'],
      description: 'Air Methods Corporation is an American privately owned helicopter operator.The air medical division provides emergency medical services to 70, 000 - 100, 000 patients every year.',
      progress: 1837593,
      target: 4200000
    };
    const projWindmills: Project = {
      name: 'Windmolens in Zweden',
      category: 'energy',
      icon: 'energie',
      image: 'windmill',
      avatars: ['anna', 'rutger', 'stefan'],
      description: 'Located in the central Sweden region of Jämtland, the project will comprise 80 Vestas V136 3.6MW turbines, making it the largest onshore wind power project in Sweden.',
      progress: 283751,
      target: 350000
    };
    const projBioScience: Project = {
      name: 'Bio science in voedingsmiddelen',
      category: 'food',
      icon: 'eten',
      image: 'bio',
      avatars: ['dominique', 'hidde', 'monique'],
      description: 'Chr.Hansen A / S is a global bioscience company based in Hørsholm, Denmark that develops natural solutions for the food, beverage, nutritional, pharmaceutical and agricultural industries.',
      progress: 182745,
      target: 600000
    };

    return of([projGlassCali, projLedLights, projAirDrop, projWindmills, projBioScience]).pipe(delay(2000));
  }
}
