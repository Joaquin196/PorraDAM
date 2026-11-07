package org.elcampico.porradam.domain

import org.elcampico.porradam.data.model.Marcador

/**
 * Calcula los puntos obtenidos comparando el resultado oficial del partido
 * con la predicción (porra) introducida por el usuario.
 */
fun calcularPuntos(real: Marcador, porra: Marcador): Int {
    // Si el marcador es exactamente igual en goles locales y visitantes, se lleva la máxima puntuación (8 pts)
    if (real == porra) return 8

    var puntos = 0

    // Si acierta el signo del partido (quién gana o si hay empate: 1X2), suma 2 puntos
    if (real.signo() == porra.signo()) puntos += 2

    // Si acierta el número exacto de goles del equipo local, suma 2 puntos
    if (real.local == porra.local) puntos += 2

    // Si acierta el número exacto de goles del equipo visitante, suma 2 puntos
    if (real.visitante == porra.visitante) puntos += 2

    return puntos
}