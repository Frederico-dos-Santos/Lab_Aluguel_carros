import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, ViewChild, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  @ViewChild("nome") nome: any;
  @ViewChild("email") email: any;
  @ViewChild("cpf") cpf: any;
  @ViewChild("endereco") endereco: any;
  @ViewChild("senha") senha: any;
  @ViewChild("rg") rg: any;
  @ViewChild("profissao") profissao: any;
  @ViewChild("entidadeEmpregadora") entidadeEmpregadora: any;

  API_URL = "http://localhost:8080/api/cliente"


  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {

  }

  contratos: any[] = [];

  ngOnInit() {
    this.carregaContrato();
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

      const user = JSON.parse(localStorage.getItem('user') as any);

      const url = `${this.API_URL}/alteraCliente`;


      const body = {
        id: user?.id,
        nome: nome || user?.name,
        password: senha || user?.password,
        email: email || user?.email,
        cpf: cpf || user?.cpf,
        rg: rg || user?.rg,
        endereco: endereco || user?.endereco,
        profissao: profissao || user?.profissao,
        entidadeEmpregadora: entidadeEmpregadora || user?.entidadeEmpregadora
      };
      // console.log(body)
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
    const user = JSON.parse(localStorage.getItem('user') as any);
    const url = `${this.API_URL}/deletaCliente/${user?.id}`;
    this.http.delete(url).subscribe(res => {
      this.router.navigate(['/'])
    })
  }


  carregaContrato() {
    try {

      const user = JSON.parse(localStorage.getItem('user') as any); 
      const idCliente = Number(user.id);

      const url = `http://localhost:8080/api/contrato/retornaTodosContratos`;

      this.http.get(url).subscribe((response: any) => {
        console.log(response)
        if (Array.isArray(response)) {
          this.contratos = response.filter((contrato: any) => contrato.cliente.id === idCliente);
          console.log(this.contratos);
        }
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "carregaContrato");
    }
  }

  /*cancelarContrato(id: any) {
      try {
        console.log(contrato.id)
        const url = `http://localhost:8080/api/contrato/deletaContratoPeloId/${id}`;
        this.http.delete(url).subscribe(response => {
          console.log(response)
          alert("Contrato cancelado com Sucesso!")
        })
      } catch (err: any) {
        console.error(err, "cancelarContrato");
      }
    }*/

}
