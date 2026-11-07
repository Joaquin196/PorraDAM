package org.elcampico.porradam.ui.jornada

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.R

/**
 * Pantalla inicial de bienvenida e identificación donde el usuario introduce
 * su alias y el código del grupo para acceder a la porra de clase.
 */
@Composable
fun PantallaBienvenida(
    onEntrarClick: (alias: String, codigo: String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Estados persistentes para almacenar el texto introducido en los campos de texto
    var alias by rememberSaveable { mutableStateOf("") }
    var codigoGrupo by rememberSaveable { mutableStateOf("") }

    // Degradado vertical oscuro (Scrim) superpuesto para garantizar la legibilidad del texto sobre el fondo
    val scrimBrush = Brush.verticalGradient(
        colors = listOf(
            Color.Black.copy(alpha = 0.3f),
            Color.Black.copy(alpha = 0.7f)
        )
    )

    // Contenedor principal en capas que ocupa toda la pantalla
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Capa 1: Imagen de fondo a pantalla completa
        Image(
            painter = painterResource(id = R.drawable.fondo_pantalla_hd),
            contentDescription = null,
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        // Capa 2: Filtro de degradado oscuro sobre la imagen
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(scrimBrush)
        )

        // Capa 3: Contenedor con los elementos de texto arriba y la tarjeta de acceso abajo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Cabecera con el título de la aplicación y la descripción motivacional
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Porra",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "DAM",
                        color = Color(0xFF63D99B), // Verde corporativo característico
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Pronostica los partidos de cada jornada\ny compite con tu clase.\n¿Quién acertará más?",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }

            // Tarjeta inferior blanca flotante con los campos de entrada y botón de acceso
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Campo de texto para introducir el Alias del usuario
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "TU ALIAS",
                            color = Color.DarkGray,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        OutlinedTextField(
                            value = alias,
                            onValueChange = { alias = it },
                            placeholder = { Text("Escribe tu nombre o alias", color = Color.Gray) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.Gray
                                )
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.LightGray,
                                focusedBorderColor = Color.Black
                            )
                        )
                    }

                    // Campo de texto para introducir el código del grupo o clase
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "CÓDIGO DEL GRUPO",
                            color = Color.DarkGray,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        OutlinedTextField(
                            value = codigoGrupo,
                            onValueChange = { codigoGrupo = it },
                            placeholder = { Text("p. ej. 1A - DAM - 2026", color = Color.Gray) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Group,
                                    contentDescription = null,
                                    tint = Color.Gray
                                )
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.LightGray,
                                focusedBorderColor = Color.Black
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Botón principal de acción para entrar en la porra
                    Button(
                        onClick = { onEntrarClick(alias, codigoGrupo) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text(
                            text = "Entrar en la porra →",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun PantallaBienvenidaPreview() {
    PantallaBienvenida(onEntrarClick = { _, _ -> })
}

