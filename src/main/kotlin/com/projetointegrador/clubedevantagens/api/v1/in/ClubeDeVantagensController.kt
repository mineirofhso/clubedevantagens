package com.projetointegrador.clubedevantagens.api.v1.`in`

import com.projetointegrador.clubedevantagens.api.v1.`in`.request.CarimboRequest
import com.projetointegrador.clubedevantagens.api.v1.`in`.request.CartaoFidelidadeRequest
import com.projetointegrador.clubedevantagens.api.v1.`in`.request.PromocaoRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.awt.image.BufferedImage
import javax.validation.Valid

@RequestMapping(value = ["/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
interface ClubeDeVantagensController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = ["/promocao"])
    fun salvarPromocao(@RequestBody @Valid promocaoRequest:  PromocaoRequest?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/promocoes"])
    fun listarPromocoes(): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/{idEmpresa}/promocoes"])
    fun listarPromocoes(@PathVariable("idEmpresa") id: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/promocao/{id}"])
    fun listarPromocao(@PathVariable("id") id: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = ["/cartaofidelidade"])
    fun gerarCartaoFidelidade(@RequestBody @Valid cartaoFidelidadeRequest:  CartaoFidelidadeRequest?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = ["/carimbo"])
    fun gerarCarimbo(@RequestBody @Valid carimboRequest:  CarimboRequest?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/empresa/{cnpj}"])
    fun buscarEmpresa(@PathVariable("cnpj") cnpj: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = ["/qrcode/generate"], produces = [MediaType.IMAGE_PNG_VALUE])
    @Throws(
        Exception::class
    )
    fun generate(qrcodeData: String?): ResponseEntity<BufferedImage?>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/usuario/{cpf}"])
    fun listarDadosUsuario(@PathVariable("cpf") id: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/{idusuario}/cartoes"])
    fun listarCartaoFidelidadeByIdUsuario(@PathVariable("idusuario") id: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/cartao/{idCartao}"])
    fun detalhesCartaoFidelidadeById(@PathVariable("idCartao") id: String?): ResponseEntity<*>?

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = ["/stampcard/{id}"])
    fun carimbar(@PathVariable("id") idCarimbo: String?): ResponseEntity<*>?
}