import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../api/project.service';

import { Observable } from 'rxjs';

import { Project } from '../project/project';

@Component({
  selector: 'app-vote',
  templateUrl: 'vote.page.html',
  styleUrls: ['vote.page.scss']
})
export class VotePage implements OnInit {

  public projects$: Observable<Project[]>;

  constructor(
    private projectService: ProjectService
    ) {}

  ngOnInit(): void {
    this.projects$ = this.projectService.getProjects();
  }
}
