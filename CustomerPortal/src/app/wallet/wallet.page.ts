import { Component, OnInit } from '@angular/core';
import { WalletService } from '../api/wallet.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-wallet',
  templateUrl: 'wallet.page.html',
  styleUrls: ['wallet.page.scss']
})
export class WalletPage implements OnInit {

  public balance$: Observable<number>;
  
  constructor(private walletService:WalletService) {}

  ngOnInit(): void {
    this.balance$ = this.walletService.getBalance();
  }
}
