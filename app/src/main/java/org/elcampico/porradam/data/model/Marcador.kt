package org.elcampico.porradam.data.model

data class Marcador(val local: Int = 0, val visitante: Int = 0) {
    fun signo(): Char = when {
        local > visitante -> '1'
        local < visitante -> '2'
        else -> 'X'
    }
}