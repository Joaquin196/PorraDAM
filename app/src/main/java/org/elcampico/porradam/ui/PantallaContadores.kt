package org.elcampico.porradam.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Componente reutilizable que dibuja una tarjeta de contador genérica.
 * Es un componente sin estado propio (stateless): recibe el valor y la acción por parámetros.
 */
@Composable
fun TarjetaContador(
    titulo: String,
    veces: Int,
    onSumar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = titulo, fontWeight = FontWeight.Bold)
                Text(text = "$veces", fontSize = 32.sp)
            }
            Button(onClick = onSumar) { Text("+1") }
        }
    }
}

/**
 * Contador basado en 'remember'.
 * El estado sobrevive a las recomposiciones, pero se pierde si el composable
 * sale de la interfaz o si se gira la pantalla.
 */
@Composable
fun ContadorRemember(modifier: Modifier = Modifier) {
    var veces by remember { mutableStateOf(0) }
    TarjetaContador(
        titulo = "remember",
        veces = veces,
        onSumar = { veces++ },
        modifier = modifier
    )
}

/**
 * Contador basado en 'rememberSaveable'.
 * Además de sobrevivir a la recomposición, el estado se guarda en el Bundle,
 * por lo que sobrevive a cambios de configuración (como rotaciones de pantalla).
 */
@Composable
fun ContadorSaveable(modifier: Modifier = Modifier) {
    var veces by rememberSaveable { mutableStateOf(0) }
    TarjetaContador(
        titulo = "rememberSaveable",
        veces = veces,
        onSumar = { veces++ },
        modifier = modifier
    )
}

/**
 * Contador gestionado mediante un 'ViewModel'.
 * El estado vive fuera de la jerarquía de Compose, sobreviriendo tanto a cambios
 * de configuración como a la destrucción temporal del componente.
 */
@Composable
fun ContadorConViewModel(
    modifier: Modifier = Modifier,
    vm: ContadorViewModel = viewModel()
) {
    TarjetaContador(
        titulo = "ViewModel",
        veces = vm.veces,
        onSumar = vm::sumar,
        modifier = modifier
    )
}

/**
 * Pantalla principal que agrupa un interruptor de visibilidad y los tres tipos
 * de contadores para comparar su comportamiento frente al ciclo de vida.
 */
@Composable
fun PantallaContadores(modifier: Modifier = Modifier) {
    // Estado que controla si los contadores se muestran u ocultan en pantalla
    var visibles by rememberSaveable { mutableStateOf(0 == 0) } // o true

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Tres contadores",
            style = MaterialTheme.typography.headlineSmall
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = visibles,
                onCheckedChange = { visibles = it }
            )
            Spacer(Modifier.width(8.dp))
            Text(if (visibles) "Contadores visibles" else "Ocultos")
        }

        // Si el interruptor se desactiva, los componentes salen de la composición
        if (visibles) {
            ContadorRemember()
            ContadorSaveable()
            ContadorConViewModel()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaContadorPreview() {
    TarjetaContador(titulo = "remember", veces = 3, onSumar = {})
}

