import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../api/project.service';

import { Observable } from 'rxjs';

import { Project } from '../project/project';
import { AlertController } from '@ionic/angular';
import { WalletService } from '../api/wallet.service';

@Component({
  selector: 'app-vote',
  templateUrl: 'vote.page.html',
  styleUrls: ['vote.page.scss']
})
export class VotePage implements OnInit {

  public projects$: Observable<Project[]>;

  constructor(
    private alertController: AlertController,
    private projectService: ProjectService,
    private walletService: WalletService
    ) {}

  ngOnInit(): void {
    this.projects$ = this.projectService.getProjects();
  }

  public vote(project: Project): void {
    const alert = this.alertController.create({
      header: 'Confirm Vote',
      message: `Are you sure you want to vote on "${project.name}"?`,
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary'
        }, {
          text: 'Vote',
          handler: () => {
            this.onVoteConfirm(project);
          }
        }
      ]
    }).then(a => {
      a.present();
    });
  }

  private onVoteConfirm(project: Project): void {
    // this.walletService.
    console.log('Vote Confirm');
  }

}
