package org.elcampico.porradam.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.data.JornadaDePrueba
import org.elcampico.porradam.data.model.Equipo
import org.elcampico.porradam.ui.theme.PorraDAMTheme

/**
 * Componente visual reutilizable que representa el escudo o emblema de un equipo
 * mediante un círculo coloreado con sus iniciales en el centro.
 */
@Composable
fun EscudoEquipo(
    equipo: Equipo,
    modifier: Modifier = Modifier,
    tamano: Dp = 36.dp
) {
    Box(
        modifier = modifier
            .size(tamano)
            .clip(CircleShape)
            // Aplica el color corporativo específico del equipo
            .background(Color(equipo.color)),
        contentAlignment = Alignment.Center
    ) {
        // Iniciales del equipo centradas dentro del círculo
        Text(
            text = equipo.iniciales,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EscudoEquipoPreview() {
    PorraDAMTheme {
        EscudoEquipo(JornadaDePrueba.partidos[0].local)
    }
}