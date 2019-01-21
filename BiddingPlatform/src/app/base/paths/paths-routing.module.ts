import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from '../../components/register/register.component'
import {ItemsComponent} from "../../components/items/items.component";
import {HomeComponent} from "../home/home.component";
import {CartComponent} from "../../components/cart/cart.component";
import {AboutComponent} from "../../components/about/about.component";
import {ItemComponent} from "../../components/item/item.component";
import {AdminComponent} from "../../components/admin/admin.component";
import {MessagesComponent} from "../../components/messages/messages.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'cart', component: CartComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'items/:category', component: ItemsComponent },
  { path: 'item/:id', component: ItemComponent },
  { path: 'grid', component: CartComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'about', component: AboutComponent },
  { path: 'blackfriday', redirectTo: '/items/blackfriday', pathMatch: 'full' }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PathsRoutingModule { }
