package org.elcampico.porradam.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

/**
 * ViewModel encargado de gestionar el estado y la lógica de contadores o pruebas
 * dentro de la aplicación, manteniendo los datos a Salvo de cambios de configuración (como giros de pantalla).
 */
class ContadorViewModel : ViewModel() {

    // Estado observable que almacena el valor actual del contador.
    // Su modificador 'private set' garantiza que la interfaz solo pueda leerlo,
    // obligando a modificarlo a través de las funciones del ViewModel.
    var veces by mutableStateOf(0)
        private set

    /**
     * Incrementa en una unidad el valor del contador.
     */
    fun sumar() {
        veces++
    }
}

