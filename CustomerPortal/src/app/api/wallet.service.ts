import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { of, Observable } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private http:HttpClient) { }

  public getBalance(): Observable<number> {
    return of(1000).pipe(delay(2000));
  }
  
}
