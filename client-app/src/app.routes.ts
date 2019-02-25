import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from "./app/home/home.component";
import { CadastroComponent } from "./app/usuario/cadastro/cadastro.component";
import { ConsultaComponent } from './app/consulta/consulta.component';

const appRoutes: Routes = [
    {path: 'home',                          component:HomeComponent},
    {path: '',                              component:HomeComponent},
    {path: 'consulta-usuario',              component:ConsultaComponent},
    {path: 'cadastro-usuario',              component:CadastroComponent},
    {path: 'cadastro-usuario/:codigo',      component:CadastroComponent},
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);