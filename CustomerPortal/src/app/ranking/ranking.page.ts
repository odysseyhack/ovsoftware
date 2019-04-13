import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-ranking',
  templateUrl: 'ranking.page.html',
  styleUrls: ['ranking.page.scss']
})
export class RankingPage implements OnInit {

  public balance$: Observable<number>;
  
  constructor() {}

  ngOnInit(): void {
  }
}
