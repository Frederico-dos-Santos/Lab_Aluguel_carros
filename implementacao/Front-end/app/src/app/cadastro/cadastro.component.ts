import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

  @ViewChild("nome") nome: any;
  @ViewChild("email") email: any;
  @ViewChild("cpf") cpf: any;
  @ViewChild("endereco") endereco: any;
  @ViewChild("senha") senha: any;
  @ViewChild("rg") rg: any;
  @ViewChild("profissao") profissao: any;
  @ViewChild("entidadeEmpregadora") entidadeEmpregadora: any;


  constructor(private http: HttpClient, private router: Router){}


  cadastrar() {
    try {
      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const cpf = this.cpf.nativeElement.value;
      const rg = this.rg.nativeElement.value;
      const endereco = this.endereco.nativeElement.value;
      const senha = this.senha.nativeElement.value;
      const profissao = this.senha.nativeElement.value;
      const entidadeEmpregadora = this.entidadeEmpregadora.nativeElement.value;

      const url = 'http://localhost:8080/api/cliente/insereCliente';
      const body = {
        nome: nome,
        password: senha,
        email: email,
        cpf: cpf,
        rg: rg,
        endereco: endereco,
        profissao: profissao,
        entidadeEmpregadora: entidadeEmpregadora,
      };

      this.http.post(url, body).subscribe(response => {
        response == 'valid' ? this.router.navigate(['/login']) : console.error('Erro cadastrar()');
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "cadastrar");
    }

  }

}
