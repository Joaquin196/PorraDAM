package org.elcampico.porradam.data.model

data class Equipo(
    val nombre: String,
    val iniciales: String,
    val color: Long // Guardado como Long para evitar dependencias de Compose
)