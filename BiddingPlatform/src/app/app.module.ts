import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MatFormFieldModule, MatInputModule, MatToolbarModule, MatMenuModule, MatIconModule, MatTreeModule, MatGridListModule, MatCardModule, MatButtonModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from '@angular/cdk/layout';
import {PathsModule} from './paths/paths.module'

import { CategoriesComponent } from './base/categories/categories.component';
import { DashbComponent } from './base/dashb/dashb.component';
import { TreeComponent } from './base/tree/tree.component';
import { RegisterComponent } from './components/register/register.component';
import { AddressComponent } from './components/address/address.component';


@NgModule({
  declarations: [
    AppComponent,
    CategoriesComponent,
    RegisterComponent,
    DashbComponent,
    TreeComponent,
    AddressComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatTreeModule,
    MatGridListModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    LayoutModule,
    PathsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
