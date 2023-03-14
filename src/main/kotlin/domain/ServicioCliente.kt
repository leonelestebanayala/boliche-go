package domain

import data.di.clienteRepositorioProvider
import data.di.tragoRepositorioProvider
import presentation.di.menuProvider


class ServicioCliente {
    fun opcionCliente() {
        clienteRepositorioProvider().ingresarDatos()
        println("1. Comprar tragos")
        println("2. Volver al menú principal")
        println("3. Salir")
        when(readLine()?.toIntOrNull()) {
            1 -> tragoRepositorioProvider().comprarTrago()
            2 -> menuProvider().volverMenuPrincipal()
            3 -> menuProvider().opciónSalir()
            else -> println("Opción no válida.")
        }
    }
}