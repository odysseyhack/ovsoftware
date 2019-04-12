import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from '../project/project.component';
import { IonicModule } from '@ionic/angular';

@NgModule({
  declarations: [
    ProjectComponent
  ],
  imports: [
    CommonModule,
    IonicModule
  ],
  exports: [
    ProjectComponent
  ]
})
export class ComponentsModule { }
