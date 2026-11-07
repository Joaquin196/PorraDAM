package org.elcampico.porradam.ui.resultados

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.data.model.Partido

/**
 * Tarjeta que muestra el enfrentamiento oficial de un partido, el marcador real,
 * la predicción (porra) introducida por el usuario y los puntos obtenidos en formato de insignia.
 */
@Composable
fun ResultadoCard(
    partido: Partido,
    golesLocalOficial: Int,
    golesVisitanteOficial: Int,
    golesLocalPorra: Int,
    golesVisitantePorra: Int,
    puntosObtenidos: Int,
    modifier: Modifier = Modifier
) {
    // Define el color de fondo y de texto de la insignia según si se han sumado puntos o no
    val (colorFondoPuntos, colorTextoPuntos) = when {
        puntosObtenidos > 0 -> Pair(Color(0xFFD1E7DD), Color(0xFF0F5132)) // Verde éxito (acierto)
        else -> Pair(Color(0xFFF8D7DA), Color(0xFF842029)) // Rojo fallo (sin puntos)
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Columna principal con los nombres de los equipos, marcadores oficiales y la porra del usuario
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Fila del equipo local y sus goles oficiales
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = partido.local.nombre,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        text = "$golesLocalOficial",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                // Fila del equipo visitante y sus goles oficiales
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = partido.visitante.nombre,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        text = "$golesVisitanteOficial",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Etiqueta informativa que muestra el pronóstico (porra) que guardó el usuario
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF1F3F5)
                ) {
                    Text(
                        text = "Tu porra: $golesLocalPorra - $golesVisitantePorra",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Insignia lateral que destaca los puntos obtenidos en este partido concreto
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = colorFondoPuntos,
                modifier = Modifier.size(width = 56.dp, height = 48.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (puntosObtenidos > 0) "+$puntosObtenidos" else "$puntosObtenidos",
                        color = colorTextoPuntos,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

