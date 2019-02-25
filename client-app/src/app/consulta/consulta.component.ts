import { Component, OnInit } from '@angular/core';
 
import {Router} from '@angular/router';
 
import {UsuarioService} from '../services/usuario.service';
 
import {Usuario} from '../services/usuario';
 
import {Response} from '../services/response';
 
@Component({
    selector: 'app-consulta-usuario',
    templateUrl: './consulta.component.html',
    styleUrls:["./consulta.component.css"]
  })
  
  export class ConsultaComponent implements OnInit {
 
    private usuarios: Usuario[] = new Array();
    private titulo:string;
 
    constructor(private usuarioService: UsuarioService,
                private router: Router){}
 
    ngOnInit() {
 
      /*SETA O TÍTULO */
      this.titulo = "Registros Cadastrados";
 
      /*CHAMA O SERVIÇO E RETORNA TODAS AS PESSOAS CADASTRADAS */
      this.usuarioService.getUsuarios().subscribe(res => this.usuarios = res);
    }
 
    /**EXCLUI UM REGISTRO QUANDO CLICAMOS NA OPÇÃO EXCLUIR DE UMA 
     * LINHA DA TABELA*/
    excluir(codigo:number, index:number):void {
 
      if(confirm("Deseja realmente excluir esse registro?")){
 
        /*CHAMA O SERVIÇO PARA REALIZAR A EXCLUSÃO */
        this.usuarioService.excluirUsuario(codigo).subscribe(response => {
 
              /**PEGA O RESPONSE DO SERVIÇO */
              let res:Response = <Response>response;
 
              /*1 = SUCESSO
              * MOSTRAMOS A MENSAGEM RETORNADA PELO SERVIÇO E DEPOIS REMOVEMOS
              O REGISTRO DA TABELA HTML*/
              if(res.codigo == 1){
                alert(res.mensagem);
                this.usuarios.splice(index,1);
              }
              else{
                /*0 = EXCEPTION GERADA NO SERVIÇO JAVA */
                alert(res.mensagem);
              }
          },
          (erro) => {                    
               /*MOSTRA ERROS NÃO TRATADOS */
               alert(erro);
          });        
      }
 
    }
 
    editar(codigo:number):void{
 
      this.router.navigate(['/cadastro-usuario',codigo]);
 
    }
 
  }