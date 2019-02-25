import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { ConfigService } from './services/config.service';
import { UsuarioService } from './services/usuario.service';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './usuario/cadastro/cadastro.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { MenuComponent } from './menu/menu.component';

import { routing } from './../app.routes';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ConsultaComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing
  ],
  providers: [ConfigService, UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
