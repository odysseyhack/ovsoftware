import { TestBed } from '@angular/core/testing';

import { ProjectService } from './project.service';
import { Project } from '../project/project';

describe('ProjectService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProjectService = TestBed.get(ProjectService);
    expect(service).toBeTruthy();
  });

  it('should get projects', async () => {
    const service: ProjectService = TestBed.get(ProjectService);
    const projects: Project[] = await service.getProjects().toPromise();
    expect(projects.length).toBe(6);
  });
});
