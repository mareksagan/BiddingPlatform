import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PathsModule } from './base/paths/paths.module'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BiddingPlatform';
  client = null;

  constructor(private http: HttpClient){
    let subscription = this.http.get('http://localhost:8080/client')
      .subscribe(response => this.client = response);
  }

}
