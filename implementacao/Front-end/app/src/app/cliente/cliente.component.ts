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

  contratando = false;

  visualizaCarros(): void {
    try {
      const url = 'http://localhost:8080/api/veiculo/retornaTodosVeiculos';

      this.http.get(url).subscribe(response => {
        console.log(response);
        this.carros = response as any;
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "visualizaCarros");
    }
  }

  contratar(carro: any): void {

    try {
      const preco = this.preco.nativeElement.value;

      const url = 'http://localhost:8080/api/cliente/contratarVeiculo';

      const body = {
        "placa": carro.idVeiculo,
        "preco": preco
      };

      this.contratando = true;

      this.http.post(url, body).subscribe(response => {
        console.log('res', response)
        this.router.navigate(['/perfil']);
      }, error => {
        console.log('Erro: ', error);
      });
    } catch (err: any) {
      console.error(err, "contratar");
    }
  }

}
