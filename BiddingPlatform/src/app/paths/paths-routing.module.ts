import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TreeComponent} from "../base/tree/tree.component";

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'tree', component: TreeComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PathsRoutingModule { }
