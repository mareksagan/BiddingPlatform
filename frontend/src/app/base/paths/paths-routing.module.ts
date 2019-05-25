import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../../components/login/login.component';
import { ItemsComponent } from '../../components/items/items.component';
import { ItemComponent } from '../../components/item/item.component';
import { HomeComponent } from '../home/home.component';
import { CartComponent } from '../../components/cart/cart.component';
import { AboutComponent } from '../../components/about/about.component';
import { AdminComponent } from '../../components/admin/admin.component';
import { MessagesComponent } from '../../components/messages/messages.component';
import { SettingsComponent } from '../../components/settings/settings.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'cart', component: CartComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'signup', component: LoginComponent },
  { path: 'settings', component: SettingsComponent },
  { path: 'items/:category', component: ItemsComponent },
  { path: 'search/:phrase', component: ItemsComponent },
  { path: 'item/:id', component: ItemComponent },
  { path: 'grid', component: CartComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about', component: AboutComponent },
  { path: 'blackfriday', redirectTo: '/items/blackfriday', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class PathsRoutingModule { }
