package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.Empresa


class EmpresaResponse(empresa: Empresa) {
     var id: String?

     var razaoSocial: String?

     var cnpj: String?

     var contatoNome: String?

     var contatoTelefone: String?

     var contatoEmail: String?

    init {
        id = empresa.empresaId
        razaoSocial = empresa.razaoSocial
        cnpj = empresa.cnpj
        contatoNome = empresa.contatoNome
        contatoTelefone = empresa.contatoTelefone
        contatoEmail = empresa.contatoEmail
    }
}