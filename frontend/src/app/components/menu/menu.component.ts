import { ChangeDetectionStrategy, Component } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  changeDetection: ChangeDetectionStrategy.Default
})

export class MenuComponent {

  constructor(private router : Router) {
  }

  ngOnInit() {
  }

  public goToUrl(url : string){
    this.router.navigateByUrl(url);
  }
}
