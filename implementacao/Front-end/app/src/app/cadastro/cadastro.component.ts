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
  @ViewChild("endereco") endereco: any;
  @ViewChild("data") data: any;
  @ViewChild("senha") senha: any;


  constructor(private http: HttpClient, private router: Router){}


  cadastrar() {
    try {
      const nome = this.nome.nativeElement.value;
      const email = this.email.nativeElement.value;
      const endereco = this.endereco.nativeElement.value;
      const date = this.data.nativeElement.value;
      const senha = this.senha.nativeElement.value;

      const url = 'http://localhost:8080/cadastrar';
      const data = {
        nome: nome,
        email: email,
        endereco: endereco,
        date: date,
        senha: senha
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
