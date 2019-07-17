import { Component, OnInit, Inject } from '@angular/core';

import { Observable, of, from } from 'rxjs';
import Web3 from 'web3';

import { WEB3 } from '../web3/web3';
import { map, delay } from 'rxjs/operators';
// import { WalletService } from '../api/wallet.service';

@Component({
  selector: 'app-wallet',
  templateUrl: 'wallet.page.html',
  styleUrls: ['wallet.page.scss']
})
export class WalletPage implements OnInit {

  public balance$: Observable<number>;
  
  constructor(@Inject(WEB3) private web3: Web3) {}

  ngOnInit(): void {
    (window as any).thomasW3 = this.web3; //TODO debug stuff, remove me

    // The first time you use this token in your code you should call the enablemethod of window.ethereum
    // It's a Promise
    // this.web3.currentProvider.enable().then( ... );
    // or async method : await enable();

    from(this.web3.eth.getAccounts()).subscribe(accounts => {
      console.log ('Ik heb nu in de app accounts gelezen!');
      console.log(accounts);

      this.balance$ = from(this.web3.eth.getBalance(accounts[0])).pipe(
        map(Number),
        delay(1500)
      );
    });

  }
}
