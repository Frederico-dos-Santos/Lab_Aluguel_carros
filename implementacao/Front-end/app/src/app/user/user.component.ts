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
  @ViewChild("data") data: any;
  @ViewChild("senha") senha: any;
  @ViewChild("rg") rg: any;
  @ViewChild("profissao") profissao: any;

  constructor(private http: HttpClient,){

  }

  cadastrar() {
    try {
      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const cpf = this.cpf.nativeElement.value;
      const rg = this.rg.nativeElement.value;
      const date = this.data.nativeElement.value;
      const senha = this.senha.nativeElement.value;
      const profissao = this.senha.nativeElement.value;

      const url = 'http://localhost:8080/editar';
      const data = {
        nome: nome,
        email: email,
        cpf: cpf,
        rg: rg,
        date: date,
        senha: senha,
        profissao: profissao
      };

      this.http.put(url, data).subscribe(response => {

      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "editar");
    }

  }

}
