import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from '@angular/cdk/layout';
import { RouterModule } from '@angular/router';

import { PathsModule } from './base/paths/paths.module'
import { CategoriesComponent } from './base/categories/categories.component';
import { RegisterComponent } from './components/register/register.component';
import { ZorrogridComponent } from './components/zorrogrid/zorrogrid.component';
import { ZorroregisterComponent } from './components/zorroregister/zorroregister.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutComponent } from './components/layout/layout.component';
import { ItemsComponent } from './components/items/items.component';
import { MenuComponent } from './components/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriesComponent,
    RegisterComponent,
    ZorrogridComponent,
    ZorroregisterComponent,
    LayoutComponent,
    ItemsComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgZorroAntdModule,
    HttpClientModule,
    LayoutModule,
    PathsModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
