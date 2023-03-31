import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent {

  URL : string = 'http://localhost:8080/api/cliente/retornaTodosClientes'

  clientes !: Array<any>

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.http.get(this.URL).subscribe((res)=>{
      this.clientes = res as any
    })
  }

}
