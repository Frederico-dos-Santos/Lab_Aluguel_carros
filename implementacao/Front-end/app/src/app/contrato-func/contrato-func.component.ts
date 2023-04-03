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

  constructor(private http : HttpClient, private router: Router){}




  recusar(){
    const URL = ''

    this.http.delete(URL).subscribe(response => {
      // console.log('res', response)
       this.router.navigate(['/funcionario']);
    }, error => {
      console.log('Erro: ', error);
    });

  }

  editar(){

    const URL = ''

    const valor = this.valor.nativeElement.value;
    const veiculo = this.veiculo.nativeElement.value;

    const body = {
      "valor" : valor,
      "veiculo": veiculo
    }

    this.http.put(URL, body).subscribe(response => {
      console.log('res', response)
       this.router.navigate(['/funcionario']);
    }, error => {
      console.log('Erro: ', error);
    });


  }

}
