import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.visualizaCarros();
  }

  @ViewChild("preco") preco: any;

  carros: any[] = [];

  visualizaCarros(): void {
    try {
      const url = 'http://localhost:8080/api/veiculo/retornaTodosVeiculos';

      this.http.get(url).subscribe(response => {
        console.log(response);
        this.carros = response as any;
        this.carros = this.carros.filter(carro => carro.alugado == false);
      }, error => {
        console.log('Erro: ', error);
      });

    } catch (err: any) {
      console.error(err, "visualizaCarros");
    }
  }

  contratar(carro: any, preco: any): void {

    try {

      const url = 'http://localhost:8080/api/contrato/criaContrato';

      const user = JSON.parse(localStorage.getItem('user') as any);      
      console.log(user.id)

      const body = {
        "idCliente": user.id,
        "idVeiculo": carro.id,
        "ativo": true,
        "valor": Number(preco.value),
        "contratoCredito": false,
      };

      console.log(body)

      console.log(preco.value)

      this.http.post(url, body).subscribe(response => {
        console.log('res', response)
        this.router.navigate(['/user']);
      }, error => {
        console.log('Erro: ', error);
      });

      const urlPut = 'http://localhost:8080/api/veiculo/alteraVeiculo';

      const veiculo = {
        "id": carro.id,
        "ano": carro.ano,
        "matricula": carro.matricula,
        "marca": carro.marca,
        "modelo": carro.modelo,
        "propietario": carro.propietario,
        "alugado": true,
        "placa": carro.placa
      }

      this.http.put(urlPut, veiculo).subscribe(response => {
        console.log('res', response)
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "contratar");
    }
  }

}
