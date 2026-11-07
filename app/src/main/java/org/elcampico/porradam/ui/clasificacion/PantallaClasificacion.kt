package org.elcampico.porradam.ui.clasificacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Modelo de datos que representa a cada participante en la tabla de clasificación.
 */
data class Participante(
    val puesto: Int,
    val nombre: String,
    val puntos: Int,
    val esUsuarioActual: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PantallaClasificacion(
    modifier: Modifier = Modifier
) {
    // Lista de prueba con los compañeros de clase y sus puntuaciones acumuladas
    val listaParticipantes = listOf(
        Participante(1, "Nicolas", 142),
        Participante(2, "Pablo", 135),
        Participante(3, "Joaquín", 128, esUsuarioActual = true),
        Participante(4, "Javier", 115),
        Participante(5, "Hilario", 110),
        Participante(6, "Cristian", 98),
        Participante(7, "Gonzalo", 95),
        Participante(8, "Alejandro", 88)
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFFF4F6F8),
        // Barra superior de la aplicación
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Porra DAM",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                },
                actions = {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFD1E7DD),
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text(
                            text = "38 pts",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            color = Color(0xFF0F5132),
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        // Barra de navegación inferior fija con el icono de Clasificación activo
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.CalendarToday, contentDescription = "Jornada", tint = Color.Gray)
                            }
                            Text("Jornada", fontSize = 11.sp, color = Color.Gray)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.SportsSoccer, contentDescription = "Resultados", tint = Color.Gray)
                            }
                            Text("Resultados", fontSize = 11.sp, color = Color.Gray)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.EmojiEvents, contentDescription = "Clasificación", tint = Color(0xFF0F5132))
                            }
                            Text("Clasificación", fontSize = 11.sp, color = Color(0xFF0F5132), fontWeight = FontWeight.Bold)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Gray)
                            }
                            Text("Perfil", fontSize = 11.sp, color = Color.Gray)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(108.dp)
                                .height(4.dp)
                                .background(Color.DarkGray, shape = RoundedCornerShape(2.dp))
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            // Cabecera de la sección
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Clasificación General",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Ranking oficial de la temporada",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            // Lista vertical desplazable con los participantes ordenados por puntos
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 8.dp)
            ) {
                itemsIndexed(listaParticipantes) { index, participante ->
                    val puestoReal = index + 1

                    // Destaca el fondo en verde claro si es el usuario actual (Joaquín)
                    val colorFondo = if (participante.esUsuarioActual) {
                        Color(0xFFE8F5E9)
                    } else {
                        Color.White
                    }

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = colorFondo),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // Insignia circular para la posición (con colores de podio para el Top 3)
                                Surface(
                                    shape = CircleShape,
                                    color = when (puestoReal) {
                                        1 -> Color(0xFFFFD700) // Oro
                                        2 -> Color(0xFFC0C0C0) // Plata
                                        3 -> Color(0xFFCD7F32) // Bronce
                                        else -> Color(0xFFE9ECEF)
                                    },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "$puestoReal",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (puestoReal <= 3) Color.White else Color.DarkGray
                                        )
                                    }
                                }

                                Text(
                                    text = participante.nombre,
                                    fontSize = 16.sp,
                                    fontWeight = if (participante.esUsuarioActual) FontWeight.Bold else FontWeight.Medium,
                                    color = Color.Black
                                )
                            }

                            // Puntuación total del participante
                            Text(
                                text = "${participante.puntos} pts",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F5132)
                            )
                        }
                    }
                }
            }
        }
    }
}

