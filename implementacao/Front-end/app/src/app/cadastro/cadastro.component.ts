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
  @ViewChild("entidadeEmpregadora1") entidadeEmpregadora1: any;
  @ViewChild("salario1") salario1: any;
  @ViewChild("entidadeEmpregadora2") entidadeEmpregadora2: any;
  @ViewChild("salario2") salario2: any;
  @ViewChild("entidadeEmpregadora3") entidadeEmpregadora3: any;
  @ViewChild("salario3") salario3: any;


  constructor(private http: HttpClient, private router: Router){}


  cadastrar() {

      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const cpf = this.cpf.nativeElement.value;
      const rg = this.rg.nativeElement.value;
      const endereco = this.endereco.nativeElement.value;
      const senha = this.senha.nativeElement.value;
      const profissao = this.senha.nativeElement.value;
      const entidadeEmpregadora1 = this.entidadeEmpregadora1.nativeElement.value;
      const salario1 = this.salario1.nativeElement.value;
      const entidadeEmpregadora2 = this.entidadeEmpregadora2?.nativeElement.value || null;
      const salario2 = this.salario2?.nativeElement.value || null;
      const entidadeEmpregadora3 = this.entidadeEmpregadora3?.nativeElement.value || null;
      const salario3 = this.salario3?.nativeElement.value || null;

      const url = 'http://localhost:8080/api/cliente/insereCliente';
      let body = {
        "name": nome,
        "password": senha,
        "email": email,
        "cpf": cpf,
        "rg": rg,
        "endereco": endereco,
        "profissao": profissao,
        "entidadeEmpregadora1": entidadeEmpregadora1,
        "salario1": salario1,
        "entidadeEmpregadora2": null,
        "salario2": null,
        "entidadeEmpregadora3": null,
        "salario3": null,
      };

      if (entidadeEmpregadora2 && salario2) {
        body = {
          ...body,
          "entidadeEmpregadora2": entidadeEmpregadora2,
          "salario2": salario2
        };
      }
    
      if (entidadeEmpregadora3 && salario3) {
        body = {
          ...body,
          "entidadeEmpregadora3": entidadeEmpregadora3,
          "salario3": salario3
        };
      }
      console.log(body)


      this.http.post(url, body).subscribe(response => {
        console.log('res', response)
         this.router.navigate(['/login']);
      }, error => {
        console.log('Erro: ', error);
      });

  }

}
