import { Component, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @ViewChild("email") email: any;
  @ViewChild("senha") senha: any;

  constructor(private http: HttpClient, private router: Router) { }

  invalido: boolean = false;

  logar() {
    try {
      const email = this.email.nativeElement.value;
      const senha = this.senha.nativeElement.value;

      const url = 'http://localhost:8080/logar';
      const data = {
        email: email,
        senha: senha
      };

      this.http.post(url, data).subscribe(response => {
        response == 'valid' ? this.router.navigate(['/user'], { queryParams: { usuario: email } }) : this.invalido = false;
      }, error => {
        this.invalido = true;
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "logar");
    }

  }
}
