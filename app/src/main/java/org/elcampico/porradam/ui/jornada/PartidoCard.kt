package org.elcampico.porradam.ui.jornada

import androidx.compose.foundation.BorderStroke
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
 * Tarjeta individual que representa un partido de la jornada, permitiendo
 * al usuario introducir los goles pronosticados para el equipo local y visitante.
 */
@Composable
fun PartidoCard(
    partido: Partido,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Fila correspondiente al equipo local y su marcador pronosticado
            FilaEquipoPartido(
                nombreEquipo = partido.local.nombre,
                goles = "2" // Valor estático provisional para pruebas
            )

            // Fila correspondiente al equipo visitante y su marcador pronosticado
            FilaEquipoPartido(
                nombreEquipo = partido.visitante.nombre,
                goles = "1" // Valor estático provisional para pruebas
            )
        }
    }
}

/**
 * Subcomponente interno que estructura la línea de cada equipo dentro de la tarjeta,
 * mostrando su nombre, la caja con los goles y los botones de incremento/decremento.
 */
@Composable
private fun FilaEquipoPartido(
    nombreEquipo: String,
    goles: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = nombreEquipo,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Caja visual que muestra el número actual de goles introducidos
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF8F9FA),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text(
                    text = goles,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            // Botones en columna para subir o bajar la cantidad de goles (incrementar/reducir)
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                SmallFloatingActionButton(
                    onClick = { },
                    modifier = Modifier.size(20.dp),
                    containerColor = Color(0xFFF1F3F5)
                ) {
                    Text("▲", fontSize = 9.sp, color = Color.DarkGray)
                }
                SmallFloatingActionButton(
                    onClick = { },
                    modifier = Modifier.size(20.dp),
                    containerColor = Color(0xFFF1F3F5)
                ) {
                    Text("▼", fontSize = 9.sp, color = Color.DarkGray)
                }
            }
        }
    }
}

