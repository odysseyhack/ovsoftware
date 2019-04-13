import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon'; 
import { MatInputModule } from '@angular/material/input';
import { MatProgressBarModule } from '@angular/material/progress-bar';


@NgModule({
    imports: [MatIconModule, MatInputModule, MatProgressBarModule],
    exports: [MatIconModule, MatInputModule, MatProgressBarModule]
})
export class MaterialComponentsModule { }
