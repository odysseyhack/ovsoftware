import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectComponent } from './project/project.component';
import { UserComponent } from './user/user.component';
import { TransferComponent } from './transfer/transfer.component';
import { HomeComponent } from './home/home.component';

import { MaterialComponentsModule } from './components/material-components.module';

@NgModule({
  declarations: [
    AppComponent,
    ProjectComponent,
    UserComponent,
    TransferComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialComponentsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
