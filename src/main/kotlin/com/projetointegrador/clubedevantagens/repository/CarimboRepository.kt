package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.Carimbo
import org.springframework.data.jpa.repository.JpaRepository

interface CarimboRepository : JpaRepository<Carimbo?, String?>
