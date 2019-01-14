import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from '../../components/register/register.component'
import {ItemsComponent} from "../../components/items/items.component";
import {HomeComponent} from "../home/home.component";
import {GridComponent} from "../../components/grid/grid.component";
import {LayoutComponent} from "../../components/layout/layout.component";
import {AboutComponent} from "../../components/about/about.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'items/:category', component: ItemsComponent },
  { path: 'grid', component: GridComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'layout', component: LayoutComponent },
  { path: 'about', component: AboutComponent },
  { path: 'blackfriday', redirectTo: '/items/blackfriday', pathMatch: 'full' }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PathsRoutingModule { }
