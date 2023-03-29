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
      let nome = this.nome.nativeElement.value;
      let email = this.email.nativeElement.value;
      let cpf = this.cpf.nativeElement.value;
      let rg = this.rg.nativeElement.value;
      let endereco = this.endereco.nativeElement.value;
      let senha = this.senha.nativeElement.value;
      let profissao = this.senha.nativeElement.value;
      let entidadeEmpregadora = this.entidadeEmpregadora.nativeElement.value;

      const user = localStorage.getItem('user') as any;

      const url = `${this.API_URL}/alteraCliente`;


      const body = {
        nome: nome ,
        password: senha,
        email: email,
        cpf: cpf,
        rg: rg,
        endereco: endereco,
        profissao: profissao,
        entidadeEmpregadora: entidadeEmpregadora
      };
      console.log(body)
      this.http.put(url,body).subscribe(response => {
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
    const user = localStorage.getItem('user') as any;
    const url = `${this.API_URL}/deletaCliente/${user?.id}`;
      this.http.delete(url).subscribe(res => {
         this.router.navigate(['/'])
      })
  }

}
