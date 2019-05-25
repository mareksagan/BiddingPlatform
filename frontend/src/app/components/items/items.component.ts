import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
})
export class ItemsComponent implements OnInit, OnDestroy {

  public category: string;

  public data = null;

  private sub: any;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => this.category = params['category']);

    this.selectCategory(this.category);
  }

  ngOnDestroy(): void {}

  public selectCategory(inputCategory: string) {
    if (inputCategory !== 'blackfriday') {
      this.data = [
        {
          title: 'Title 1',
        },
        {
          title: 'Title 2',
        },
        {
          title: 'Title 3',
        },
        {
          title: 'Title 4',
        },
      ];
    } else {
      this.data = [
        {
          title: 'BF 1',
        },
        {
          title: 'BF 2',
        },
        {
          title: 'BF 3',
        },
        {
          title: 'BF 4',
        },
        {
          title: 'BF 3',
        },
        {
          title: 'BF 4',
        },
        {
          title: 'BF 1',
        },
        {
          title: 'BF 2',
        },
        {
          title: 'BF 3',
        },
        {
          title: 'BF 4',
        },
        {
          title: 'BF 3',
        },
        {
          title: 'BF 1',
        },
        {
          title: 'BF 2',
        },
        {
          title: 'BF 3',
        },
        {
          title: 'BF 4',
        },
        {
          title: 'BF 3',
        },
      ];
    }
  }

}
