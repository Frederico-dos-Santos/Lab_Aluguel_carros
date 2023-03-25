import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TesteComponent } from './teste/teste/teste.component';
import { CadastroComponent } from './cadastro/cadastro/cadastro.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    TesteComponent,
    CadastroComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
