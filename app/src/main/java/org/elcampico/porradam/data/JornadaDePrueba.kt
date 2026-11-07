package org.elcampico.porradam.data

import org.elcampico.porradam.data.model.Equipo
import org.elcampico.porradam.data.model.Partido

object JornadaDePrueba {
    private val marina = Equipo("Atlético Marina", "AM", 0xFFB3261E)
    private val costa = Equipo("Racing Costa", "RC", 0xFF1565C0)
    private val huerta = Equipo("UD Huerta", "UH", 0xFF2E7D32)
    private val albufera = Equipo("CF Albufera", "CA", 0xFFF9A825)
    private val sierra = Equipo("Real Sierra", "RS", 0xFF6A1B9A)
    private val faro = Equipo("Deportivo Faro", "DF", 0xFF00838F)
    private val olivar = Equipo("SD Olivar", "SO", 0xFF558B2F)
    private val salinas = Equipo("CD Salinas", "CS", 0xFF37474F)
    private val puerto = Equipo("Unión Puerto", "UP", 0xFFD84315)
    private val almendro = Equipo("Club Almendro", "CL", 0xFF4E342E)

    val partidos = listOf(
        Partido("j1-p1", marina, costa),
        Partido("j1-p2", huerta, albufera),
        Partido("j1-p3", sierra, faro),
        Partido("j1-p4", olivar, salinas),
        Partido("j1-p5", puerto, almendro)
    )
}