import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  constructor(private http: HttpClient){}

  ngOnInit(): void {
    try{

    const url = 'http://localhost:8080/api/veiculo/insereVeiculo';

      const body = [{
        "ano": 2023,
        "matricula": 1,
        "marca": "Fiat",
        "modelo": "Uno",
        "propietario": "Joao",
        "alugado": false,
        "placa": "abc-123"
      },
      {
        "ano": 2021,
        "matricula": 2,
        "marca": "Ford",
        "modelo": "Ka",
        "propietario": "Mario",
        "alugado": false,
        "placa": "fas-324"
      },
      {
        "ano": 2020,
        "matricula": 3,
        "marca": "Fiat",
        "modelo": "Argo",
        "propietario": "Maria",
        "alugado": false,
        "placa": "whb-645"
      },
      {
        "ano": 2022,
        "matricula": 2,
        "marca": "Ford",
        "modelo": "Fiesta",
        "propietario": "Maria",
        "alugado": false,
        "placa": "def-456"
      },
      {
        "ano": 2021,
        "matricula": 3,
        "marca": "Volkswagen",
        "modelo": "Gol",
        "propietario": "Pedro",
        "alugado": true,
        "placa": "ghi-789"
      },
      {
        "ano": 2020,
        "matricula": 4,
        "marca": "Chevrolet",
        "modelo": "Onix",
        "propietario": "Ana",
        "alugado": true,
        "placa": "jkl-012"
      },
      {
        "ano": 2019,
        "matricula": 5,
        "marca": "Toyota",
        "modelo": "Corolla",
        "propietario": "Lucas",
        "alugado": false,
        "placa": "mno-345"
      }]


    body.forEach(veiculo => {
      this.http.post(url, veiculo).subscribe(response => {
        console.log('res', response)
      }, error => {
        console.log('Erro: ', error);
      });
    });
  } catch (err: any) {
    console.error(err, "contratar");
  }
}
  

}
