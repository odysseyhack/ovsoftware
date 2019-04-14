import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  styleUrls: ['./badge.component.scss'],
})
export class BadgeComponent implements OnInit {

  @Input() icon: string;
  
  public static rankMapping: {[rank: string]: string};

  constructor() { }

  ngOnInit(): void {
    if (BadgeComponent.rankMapping == undefined) {
      BadgeComponent.rankMapping = {};
      BadgeComponent.rankMapping.energie = this.getRandomRank();
      BadgeComponent.rankMapping.eten = this.getRandomRank();
      BadgeComponent.rankMapping.hartslag = this.getRandomRank();
      BadgeComponent.rankMapping.kubussen = this.getRandomRank();
      BadgeComponent.rankMapping.stad = this.getRandomRank();
    }
  }

  public getMyRank(): string {
    return BadgeComponent.rankMapping[this.icon];
  }

  private getRandomRank(): string {
    const r = Math.random();
    if (r < 0.5) {
      return 'bronze';
    } else if (r > 0.5 && r < 0.85) {
      return 'silver';
    } else {
      return 'gold';
    }
  }

}
