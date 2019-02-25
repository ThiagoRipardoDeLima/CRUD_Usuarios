import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Usuario } from '../../services/usuario';

import { UsuarioService } from '../../services/usuario.service';

import { Response } from '../../services/response';

import { Observable } from 'rxjs/Observable';

@Component({
    selector: 'app-cadastro-usuario',
    templateUrl: './cadastro.component.html',
    styleUrls: ["./cadastro.component.css"]
})
export class CadastroComponent implements OnInit{

    private titulo:string;
    private usuario:Usuario = new Usuario();

    constructor(private usuarioService: UsuarioService,
                private router:Router,
                private activatedRoute: ActivatedRoute){}
    
    /** CARREGA NA INICIALIZAÇÃO DO COMPONENTE */
    ngOnInit(){
        this.activatedRoute.params.subscribe(parametro => {

            if(parametro["idUsuario"] == undefined){
                this.titulo = "Novo cadastro de Usuario";
            }
            else{
                this.titulo = "Editar cadastro de Usuario";
                this.usuarioService.getUsuario(Number(parametro["idUsuario"])).subscribe(res => this.usuario = res);
            }

        })
    }

    /** FUNÇÃO PARA CADASTRAR NOVO USUARIO OU ALTERAR UM EXISTENTE */
    Salvar(): void {

        /** SE NAO TIVER ID VAMOS INSERIR NOVO REGISTRO */
        if(this.usuario.idUsuario == undefined){

            /** CHAMA SERVICO PARA ADICIONAR NOVO USUARIO */
            this.usuarioService.addUsuario(this.usuario).subscribe(response => {

                /** PEGA O RESPONSE DO RETORNO DO SERVICO */
                let res:Response = <Response>response;

                /*SE RETORNOU 1 DEVEMOS MOSTRAR A MENSAGEM DE SUCESSO
                E LIMPAR O FORMULÁRIO PARA INSERIR UM NOVO REGISTRO*/
                if(res.codigo == 1){
                    alert(res.mensagem);
                    this.usuario = new Usuario();
                }
                else{
                    /*
                    ESSA MENSAGEM VAI SER MOSTRADA CASO OCORRA ALGUMA EXCEPTION
                    NO SERVIDOR (CODIGO = 0)*/
                    alert(res.mensagem);
                }
            },
            (erro) => {
                /**AQUI VAMOS MOSTRAR OS ERROS NÃO TRATADOS
                EXEMPLO: SE APLICAÇÃO NÃO CONSEGUIR FAZER UMA REQUEST NA API                        */                 
                alert(erro);
            });
        }
        else{
             /*AQUI VAMOS ATUALIZAR AS INFORMAÇÕES DE UM REGISTRO EXISTENTE */
            this.usuarioService.atualizaUsuario(this.usuario).subscribe(response => {
    
                //PEGA O RESPONSE DO RETORNO DO SERVIÇO
                let res:Response = <Response>response;
        
                /*SE RETORNOU 1 DEVEMOS MOSTRAR A MENSAGEM DE SUCESSO
                E REDIRECIONAR O USUÁRIO PARA A PÁGINA DE CONSULTA*/
                if(res.codigo == 1){
                alert(res.mensagem);
                this.router.navigate(['/consulta-usuario']);
                }
                else{
                /*ESSA MENSAGEM VAI SER MOSTRADA CASO OCORRA ALGUMA EXCEPTION
                NO SERVIDOR (CODIGO = 0)*/
                alert(res.mensagem);
                }
            },
            (erro) => {                    
                /**AQUI VAMOS MOSTRAR OS ERROS NÃO TRATADOS
                 EXEMPLO: SE APLICAÇÃO NÃO CONSEGUIR FAZER UMA REQUEST NA API                        */                 
                alert(erro);
            });
        }
    }
}