import { ClienteComponent } from './cliente/cliente.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { CadastroFuncionarioComponent } from './cadastro-funcionario/cadastro-funcionario.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { ContratoFuncComponent } from './contrato-func/contrato-func.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'criar', component: CadastroComponent},
  {path: 'criarFuncionario', component: CadastroFuncionarioComponent},
  {path: 'user', component: UserComponent},
  {path: 'funcionario', component: FuncionarioComponent},
  {path: 'veiculos', component: ClienteComponent},
  {path: 'contratosFunc', component: ContratoFuncComponent},
  {path: '', redirectTo: 'home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
