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
  @ViewChild("data") data: any;
  @ViewChild("senha") senha: any;
  @ViewChild("rg") rg: any;
  @ViewChild("profissao") profissao: any;


  constructor(private http: HttpClient, private router: Router){}


  cadastrar() {
    try {
      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const cpf = this.cpf.nativeElement.value;
      const rg = this.rg.nativeElement.value;
      const date = this.data.nativeElement.value;
      const senha = this.senha.nativeElement.value;
      const profissao = this.senha.nativeElement.value;

      const url = 'http://localhost:8080/cadastrar';
      const data = {
        nome: nome,
        email: email,
        cpf: cpf,
        rg: rg,
        date: date,
        senha: senha,
        profissao: profissao
      };

      this.http.post(url, data).subscribe(response => {
        response == 'valid' ? this.router.navigate(['/login']) : console.error('Erro cadastrar()');
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "cadastrar");
    }

  }

}
