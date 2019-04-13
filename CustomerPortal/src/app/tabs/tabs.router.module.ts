import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'vote',
        children: [
          {
            path: '',
            loadChildren: '../vote/vote.module#VotePageModule'
          }
        ]
      },
      {
        path: 'wallet',
        children: [
          {
            path: '',
            loadChildren: '../wallet/wallet.module#WalletPageModule'
          }
        ]
      },
      {
        path: 'ranking',
        children: [
          {
            path: '',
            loadChildren: '../ranking/ranking.module#RankingPageModule'
          }
        ]
      },
      {
        path: '',
        redirectTo: '/tabs/vote',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/vote',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
