import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders} from '@angular/compiler/src/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule} from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component'; /* utilizado para requests Ajax */
import { constants } from 'buffer';
import { LoginComponent } from './login/login.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ManagerComponent } from './manager/manager.component';
import { FeedComponent } from './feed/feed.component';
import { PerfilAmigoComponent } from './perfil-amigo/perfil-amigo.component';
import { GerenteComponent } from './gerente/gerente.component';


export const appRouters: Routes = [
  {path : '', component : LoginComponent},
  {path : 'home', component : HomeComponent},
  {path : 'home/**', component : HomeComponent},
  {path : 'cadastro', component : CadastroComponent},
  {path : 'perfil', component : PerfilComponent},
  {path : 'feed', component : FeedComponent},
  {path : 'feed/perfil-amigo', component : PerfilAmigoComponent},
  {path : 'feed/perfil-amigo/:id', component : PerfilAmigoComponent},
  {path : 'perfil/perfil-amigo/:id', component : PerfilAmigoComponent},
  {path : 'gerente', component : GerenteComponent} // criando a rota com parametro



];

export const routes: ModuleWithProviders = RouterModule.forRoot(appRouters);

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CadastroComponent,
    PerfilComponent,
    ManagerComponent,
    FeedComponent,
    PerfilAmigoComponent,
    GerenteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    routes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
