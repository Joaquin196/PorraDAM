package org.elcampico.porradam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.elcampico.porradam.ui.theme.PorraDAMTheme
// Importamos la pantalla de clasificación de su respectivo paquete
import org.elcampico.porradam.ui.clasificacion.PantallaClasificacion

/**
 * Actividad principal de la aplicación. Configura el modo Edge-to-Edge
 * y establece la interfaz de usuario raíz utilizando Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PorraDAMTheme {
                // Cargamos la Pantalla de Clasificación como vista inicial al arrancar la app
                PantallaClasificacion(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

/**
 * Componente de saludo por defecto generado por la plantilla de Android Studio.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorraDAMTheme {
        Greeting("Android")
    }
}