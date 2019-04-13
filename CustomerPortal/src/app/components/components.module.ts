import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from '../project/project.component';
import { IonicModule } from '@ionic/angular';
import { BadgeComponent } from '../badge/badge.component';

@NgModule({
  declarations: [
    BadgeComponent,
    ProjectComponent
  ],
  imports: [
    CommonModule,
    IonicModule
  ],
  exports: [
    BadgeComponent,
    ProjectComponent
  ]
})
export class ComponentsModule { }
