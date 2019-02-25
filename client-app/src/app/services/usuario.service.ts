import { RequestOptions } from '@angular/http';
import { Http } from "@angular/http";
import { Injectable } from "@angular/core";
import { Headers } from "@angular/http";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

import { ConfigService } from "./config.service";
import { Usuario } from "../services/usuario";

@Injectable()
export class UsuarioService{
    
    private baseUrlService:string = '';
    private headers:Headers;
    private options:RequestOptions;

    constructor(private http:Http,
                private configService:ConfigService){

        /** SETA URL DO SERVICO REST A SER ACESSADO */
        this.baseUrlService = configService.getUrlService()+'/usuarios';

        /** ADICIONA JSON NO HEADER */
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new RequestOptions({ headers: this.headers });
    }

    /** CONSULTA TODOS OS USUARIOS CADASTRADOS */
    getUsuarios(){
        return this.http.get(this.baseUrlService).map(res => res.json());
    }

    /** ADICIONA UM NOVO USUARIO */
    addUsuario(usuario: Usuario){
        return this.http.post(this.baseUrlService, JSON.stringify(usuario), this.options)
        .map(res => res.json());
    }

    /** EXCLUI UM USUARIO */
    excluirUsuario(codigo:number){
        return this.http.delete(this.baseUrlService + codigo).map(res => res.json());
    }

    /** CONSULTA UM USUARIO PELO CODIGO */
    getUsuario(codigo:number){
        return this.http.get(this.baseUrlService + codigo).map(res => res.json());
    }

    /** ATUALIZA INFORMAÇÕES DE UM USUARIO */
    atualizaUsuario(usuario: Usuario){
        return this.http.put(this.baseUrlService, JSON.stringify(usuario),this.options)
        .map(res => res.json());
    }
}