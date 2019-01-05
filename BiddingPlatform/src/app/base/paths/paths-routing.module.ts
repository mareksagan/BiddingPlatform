import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from '../../components/register/register.component'
import {ItemsComponent} from "../../components/items/items.component";
import {AppComponent} from "../../app.component";
import {CategoriesComponent} from "../categories/categories.component";

const routes: Routes = [
  { path: '',   redirectTo: '/homepage', pathMatch: 'full' },
  { path: 'homepage', component: CategoriesComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'items', component: ItemsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PathsRoutingModule { }
