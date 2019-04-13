import { Component, Input } from '@angular/core';
import { Project } from './project';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss'],
})
export class ProjectComponent {

  @Input() project: Project;

  public engaged: boolean = false;
  public rankProgress: number = Math.floor(Math.random() * 250) + 50;

  constructor(private alertController: AlertController) {}

  public getCategoryColor(): string {
    if (this.project.category === 'energy') return 'warning';
    if (this.project.category === 'infrastructure') return 'danger';
    if (this.project.category === 'health') return 'success';
    if (this.project.category === 'food') return 'secondary';
    if (this.project.category === 'city') return 'tertiary';
    return 'medium';
  }

  public vote(amount: number): void {
    const alert = this.alertController.create({
      header: 'Confirm Vote',
      message: `Are you sure you want to vote ${amount}?`,
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary'
        }, {
          text: 'Vote',
          handler: () => {
            this.project.progress += amount;
            this.rankProgress += amount;
            if (this.rankProgress > 500) {
              this.rankProgress = 500;
            }
          }
        }
      ]
    }).then(a => {
      a.present();
    });
  }

}
