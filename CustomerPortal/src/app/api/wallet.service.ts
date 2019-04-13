import { Injectable } from '@angular/core';

import { BehaviorSubject, Observable } from 'rxjs';

import { default as Web3 } from 'web3';
import { default as contract } from 'truffle-contract';
// import RetiArtifacts from '../assets/reti.json';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private web3: Web3;
  private reti: contract;

  private accounts: string[];
  private myAccount: string;

  private balance$: BehaviorSubject<number> = new BehaviorSubject(0);

  constructor() {
    this.web3 = new Web3(Web3.givenProvider || 'ws://localhost:8546', null, {});

    // this.initializeReti();
    // this.getAccounts();
  }

  public getBalance(): Observable<number> {
    return this.balance$.asObservable();
  }
  
  private initializeReti(): void {
    // this.reti = contract(RetiArtifacts);
    this.reti.setProvider(Web3.givenProvider);
  }

  private getAccounts(): void {
    this.web3.eth.getAccounts((err, accs) => {
      if (err != null) {
        console.error('Something went wrong getting the accounts');
        return;
      }
      if (accs.length === 0) {
        console.warn('Kon geen rekeningen vinden! Controleer connectie naar Ethereum, 2')
        return;
      }
      
      this.accounts = accs;
      this.myAccount = accs[0];

      this.refreshBalance();
    });
  }

  private refreshBalance(): void {
    this.reti.deployed().then(instance => {
      return instance.balanceOf.call(this.myAccount);
    }).then(balance => {
      this.balance$.next(balance);
    }).catch(function (e) {
      console.error(e);
    });
  }
}
