import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  @ViewChild("nome") nome: any;
  @ViewChild("email") email: any;
  @ViewChild("cpf") cpf: any;
  @ViewChild("endereco") endereco: any;
  @ViewChild("senha") senha: any;
  @ViewChild("rg") rg: any;
  @ViewChild("profissao") profissao: any;
  @ViewChild("entidadeEmpregadora") entidadeEmpregadora: any;

  API_URL = "http://localhost:8080/api/cliente"


  constructor(private http: HttpClient, private router: Router){

  }

  editar() {
    try {
      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const cpf = this.cpf.nativeElement.value;
      const rg = this.rg.nativeElement.value;
      const endereco = this.endereco.nativeElement.value;
      const senha = this.senha.nativeElement.value;
      const profissao = this.senha.nativeElement.value;
      const entidadeEmpregadora = this.entidadeEmpregadora.nativeElement.value;

      const url = `${this.API_URL}/insereCliente`;
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

      this.http.put(url, body).subscribe(response => {
         alert("Usuário editado com sucesso");
      }, error => {
        console.log('Erro: ', error);
        alert("Não foi possível editar o usuário")
      });
    } catch (err: any) {
      console.error(err, "editar");
    }

  }

  deletar() {
    const url = `${this.API_URL}/deletaCliente/1`;
      this.http.delete(url).subscribe(res => {
         this.router.navigate(['/'])
      })
  }

}
