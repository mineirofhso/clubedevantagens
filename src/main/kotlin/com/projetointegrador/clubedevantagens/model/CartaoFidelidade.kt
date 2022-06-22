package com.projetointegrador.clubedevantagens.model

import org.apache.logging.log4j.util.Strings
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CartaoFidelidade {
    @Id
    private var id: String? = null
        private set
    private var idPromocao: String? = null
    private var idUsuario: String? = null
    private var espacoTotal: Int = 0
    private var espacoCarimbado: Int = 0

    private var contemplado: Boolean? = null

    var empresa: String = Strings.EMPTY

    var validade: LocalDate = LocalDate.now()

    var descricao: String = Strings.EMPTY

    @Deprecated("")
    constructor() {
    }

    constructor(idPromocao: String?, idUsuario: String?, espacoTotal: Int, espacoCarimbado: Int,
    empresa: String, validade: LocalDate, descricao: String) {
        id = UUID.randomUUID().toString()
        this.idPromocao = idPromocao
        this.idUsuario = idUsuario
        this.espacoTotal = espacoTotal
        this.espacoCarimbado = espacoCarimbado
        this.descricao = descricao
        this.validade = validade
        this.empresa = empresa
    }

    fun setContemplado(contemplado: Boolean?) {
        this.contemplado = contemplado
    }

    fun getEspacoTotal(): Int {
        return espacoTotal
    }

    fun getIdUsuario(): String? {
        return idUsuario
    }

    fun getId(): String? {
        return id
    }

    fun getIdPromocao(): String? {
        return idPromocao
    }

    fun setEspacoTotal(espacoTotal: Int) {
        this.espacoTotal = espacoTotal
    }

    fun getEspacoCarimbado(): Int {
        return espacoCarimbado
    }

    fun setEspacoCarimbado(espacoCarimbado: Int) {
        this.espacoCarimbado = espacoCarimbado
    }


}