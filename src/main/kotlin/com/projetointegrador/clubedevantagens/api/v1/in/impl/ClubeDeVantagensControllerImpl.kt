package com.projetointegrador.clubedevantagens.api.v1.`in`.impl

import com.projetointegrador.clubedevantagens.api.v1.`in`.ClubeDeVantagensController
import com.projetointegrador.clubedevantagens.api.v1.`in`.request.CarimboRequest
import com.projetointegrador.clubedevantagens.api.v1.`in`.request.CartaoFidelidadeRequest
import com.projetointegrador.clubedevantagens.api.v1.`in`.request.PromocaoRequest
import com.projetointegrador.clubedevantagens.api.v1.`in`.response.CartaoFidelidadeResponse
import com.projetointegrador.clubedevantagens.api.v1.`in`.response.EmpresaResponse
import com.projetointegrador.clubedevantagens.api.v1.`in`.response.PromocaoResponse
import com.projetointegrador.clubedevantagens.api.v1.`in`.response.UsuarioResponse
import com.projetointegrador.clubedevantagens.model.*
import com.projetointegrador.clubedevantagens.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage
import java.util.*
import java.util.function.Consumer
import javax.persistence.EntityManager

@RestController
class ClubeDeVantagensControllerImpl : ClubeDeVantagensController {

    @Autowired
    private val empresaRepository: EmpresaRepository? = null

    @Autowired
    private val cartaoFidelidadeRepository: CartaoFidelidadeRepository? = null

    @Autowired
    private val promocaoRepository: PromocaoRepository? = null

    @Autowired
    var usuarioRepository: UsuarioRepository? = null

    @Autowired
    var carimboRepository: CarimboRepository? = null

    @Autowired
    var em: EntityManager? = null
    override fun salvarPromocao(promocaoRequest: PromocaoRequest?): ResponseEntity<*>? {
        val promocao: Promocao = promocaoRequest!!.toModel()
        promocaoRepository?.save(promocao)
        val promocaoResponse = PromocaoResponse(promocao)
        return ResponseEntity.status(HttpStatus.CREATED).body<Any>(promocaoResponse)
    }

    override fun listarPromocoes(): ResponseEntity<*>? {
        val promocoes = promocaoRepository!!.findAll()
        val promocoesResponse: MutableList<PromocaoResponse> = ArrayList()
        promocoes.forEach(Consumer { promocao: Promocao? ->
            promocoesResponse.add(
                PromocaoResponse(
                    promocao!!
                )
            )
        })

        return ResponseEntity.status(HttpStatus.OK).body<List<PromocaoResponse>>(promocoesResponse)
    }

    override fun listarPromocoes(id: String?): ResponseEntity<*>? {
        val promocoes = promocaoRepository!!.findByIdEmpresa(id)
        val promocoesResponse: MutableList<PromocaoResponse> = java.util.ArrayList()
        promocoes!!.forEach(Consumer { promocao: Promocao? ->
            promocoesResponse.add(
                PromocaoResponse(
                    promocao!!
                )
            )
        })

        return ResponseEntity.status(HttpStatus.OK).body<List<PromocaoResponse>>(promocoesResponse)
    }

    override fun listarPromocao(id: String?): ResponseEntity<*>? {
        val promocao = em!!.find(Promocao::class.java, id) ?: return ResponseEntity.notFound().build<Any>()

        val promocaoResponse = PromocaoResponse(promocao)

        return ResponseEntity.status(HttpStatus.OK).body<Any>(promocaoResponse)
    }

    override fun gerarCartaoFidelidade(cartaoFidelidadeRequest: CartaoFidelidadeRequest?): ResponseEntity<*>? {
        val cartaoFidelidade: CartaoFidelidade = cartaoFidelidadeRequest!!.toModel()
        cartaoFidelidadeRepository!!.save(cartaoFidelidade)
        return ResponseEntity.status(HttpStatus.CREATED).body<Any>(cartaoFidelidade)
    }

    override fun gerarCarimbo(carimboRequest: CarimboRequest?): ResponseEntity<*>? {
        val usuario = usuarioRepository!!.findBycpf(carimboRequest?.getCpf())
            ?: throw Exception("Usuário Inexistente")

        carimboRequest!!.setIdUsuario(usuario.usuarioId)
        val promocao = promocaoRepository!!.findById(carimboRequest.getIdPromocao()!!)
            ?: throw Exception("Promoção Inexistente")

        val carimbo: Carimbo = carimboRequest.toModel()!!
        val carimboId = carimboRepository?.save(carimbo)
        val urlResponse = "http://localhost:8181/v1/stampcard/" + carimboId!!.getId()
        val map = HashMap<String, String>().apply {
            put("urlCarimbo", urlResponse)
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(map)
    }

    override fun buscarEmpresa(cnpj: String?): ResponseEntity<*>? {
        val empresa: Empresa = empresaRepository?.findByCnpj(cnpj) ?: return ResponseEntity.notFound().build<Any>()

        val empresaResponse = EmpresaResponse(empresa)
        return ResponseEntity.status(HttpStatus.OK).body<Any>(empresaResponse)

    }

    override fun generate(qrcodeData: String?): ResponseEntity<BufferedImage?>? {
        TODO("Not yet implemented")
    }

    override fun listarDadosUsuario(cpf: String?): ResponseEntity<*>? {
        val usuarioBuscado: Usuario = usuarioRepository?.findBycpf(cpf) ?: return ResponseEntity.notFound().build<Any>()
        val usuarioResponse = UsuarioResponse(usuarioBuscado)
        return ResponseEntity.status(HttpStatus.OK).body<Any>(usuarioResponse)

    }

    override fun listarCartaoFidelidadeByIdUsuario(id: String?): ResponseEntity<*>? {
        val cartoes = cartaoFidelidadeRepository!!.findByIdUsuario(id)
        val cartoesResponse: MutableList<CartaoFidelidadeResponse> = java.util.ArrayList<CartaoFidelidadeResponse>()
        cartoes!!.forEach(Consumer { cartao: CartaoFidelidade? ->
            cartoesResponse.add(
                CartaoFidelidadeResponse(cartao!!)
            )
        })
        return ResponseEntity.status(HttpStatus.OK).body<List<CartaoFidelidadeResponse>>(cartoesResponse)
    }

    override fun detalhesCartaoFidelidadeById(id: String?): ResponseEntity<*>? {
        val cartao = cartaoFidelidadeRepository!!.findById(id!!).orElse(null)
            ?: return ResponseEntity.notFound().build<Any>()
        val cartaoFidelidadeResponse = CartaoFidelidadeResponse(cartao)
        return ResponseEntity.status(HttpStatus.OK).body<Any>(cartaoFidelidadeResponse)
    }

    override fun carimbar(idCarimbo: String?): ResponseEntity<*>? {
        val carimbo = carimboRepository!!.findById(idCarimbo!!)

        if (!carimbo.isPresent)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Carimbo inexistente!!!")


        if (carimbo.get().getUtilizado()!!)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Carimbo já utilizado!!!")
        val cartaoFidelidade: CartaoFidelidade = cartaoFidelidadeRepository?.findByIdUsuarioAndIdPromocao(
            carimbo.get().getIdUsuario(), carimbo.get().getIdPromocao()
        )
            ?:
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cartão Fidelidade Inexistente")
        cartaoFidelidade.setEspacoCarimbado(
            cartaoFidelidade.getEspacoCarimbado().plus(carimbo.get().getQuantidadeCarimbos()
        ))

        if (cartaoFidelidade.getEspacoCarimbado() >= cartaoFidelidade.getEspacoTotal()
        ) cartaoFidelidade.setContemplado(true)
        cartaoFidelidadeRepository.save(cartaoFidelidade)
        carimbo.get().setUtilizado(true)
        carimboRepository!!.save(carimbo.get())

        return ResponseEntity.status(HttpStatus.OK).body("Cartão carimbado com sucesso!!!")
    }
}