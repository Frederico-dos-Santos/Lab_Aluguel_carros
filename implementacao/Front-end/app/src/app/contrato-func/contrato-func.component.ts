import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contrato-func',
  templateUrl: './contrato-func.component.html',
  styleUrls: ['./contrato-func.component.css']
})
export class ContratoFuncComponent {

  @ViewChild("valor") valor: any;
  @ViewChild("veiculo") veiculo: any;

  contratos: any
  URL = 'http://localhost:8080/api/contrato/retornaTodosContratos'

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {

    this.http.get(this.URL).subscribe((response) => {
      this.contratos = response as any
      console.log(this.contratos)
    })

  }





  recusar(id: any) {
    const URL = `http://localhost:8080/api/contrato/retornaContratoPeloId/${id}`

    this.http.get(URL).subscribe((response) => {
      const contrato = response as any
      const body = {
        "ativo": false,
        "valor": contrato?.valor,
        "contratoCredito": contrato?.contratoCredito,
        "veiculo": contrato?.veiculo,
        "cliente": contrato?.cliente

      }
      this.http.put('http://localhost:8080/api/contrato/alteraContrato', body).subscribe(() => {
        alert("Foi cancelado")
      })
    }, error => {
      console.log('Erro: ', error);
    });

  }

  editar(id: any) {

    const URL = `http://localhost:8080/api/contrato/retornaContratoPeloId/${id}`

    const valor = this.valor.nativeElement.value;
    const veiculo = this.veiculo.nativeElement.value;

    this.http.get(URL).subscribe((response) => {
      const contrato = response as any
      const body = {
        "ativo": false,
        "valor": valor,
        "contratoCredito": contrato?.contratoCredito,
        "veiculo": contrato?.veiculo,
        "cliente": contrato?.cliente

      }
      this.http.put('http://localhost:8080/api/contrato/alteraContrato', body).subscribe(() => {
        alert("Foi editado")
      })


    })
  }


}
