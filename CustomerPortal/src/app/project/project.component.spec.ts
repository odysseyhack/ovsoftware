import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectComponent } from './project.component';
import { Project } from './project';

describe('ProjectComponent', () => {
  let component: ProjectComponent;
  let fixture: ComponentFixture<ProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectComponent ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should show a project', () => {
    const project: Project = {
      name: 'Glasvezelnetwerk in Californië',
      category: 'infrastructure',
      icon: 'kubussen',
      image: 'cali',
      avatars: ['trump', 'musk', 'zuckerberg'],
      description: 'Fullerton heeft een inwonertal van ongeveer 135.000. In de gemeente staan 50.000 woningen en 5.000 bedrijven. Het nieuwe glasvezelnetwerk zal over de gehele gemeente worden uitgerold.',
      progress: 647822,
      target: 800000
    };
    component.project = project;
    fixture.detectChanges();
    expect(fixture.nativeElement.querySelector('divp').innerText).toEqual('Fullerton heeft een inwonertal van ongeveer 135.000. In de gemeente staan 50.000 woningen en 5.000 bedrijven. Het nieuwe glasvezelnetwerk zal over de gehele gemeente worden uitgerold.');
  });
});
