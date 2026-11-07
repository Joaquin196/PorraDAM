package org.elcampico.porradam.data.model

data class Partido(
    val id: String,
    val local: Equipo,
    val visitante: Equipo,
    val resultado: Marcador? = null
)