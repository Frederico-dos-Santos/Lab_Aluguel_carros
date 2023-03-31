import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-cadastro-funcionario',
  templateUrl: './cadastro-funcionario.component.html',
  styleUrls: ['./cadastro-funcionario.component.css']
})
export class CadastroFuncionarioComponent {
  @ViewChild("nome") nome: any;
  @ViewChild("email") email: any;
  @ViewChild("senha") senha: any;

  constructor(private http : HttpClient, private router: Router){}

  cadastrar(){

    const url = '';

    const nome = this.nome.nativeElement.value;
    const email = this.email.nativeElement.value;
    const senha = this.senha.nativeElement.value;

    const body = {
      "name": nome,
      "password": senha,
      "email": email,
    };

    this.http.post(url, body).subscribe(response => {
      console.log('res', response)
       this.router.navigate(['/login']);
    }, error => {
      console.log('Erro: ', error);
    });
  }
}
