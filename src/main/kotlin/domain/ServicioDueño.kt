package domain

import domain.di.servicioEstadisticasProvider
import domain.di.servicioRepositoriosProvider
import presentation.di.menuProvider

class ServicioDueño {

    fun opcionDueño() {

        println("1. Repositorio de clientes")
        println("2. Repositorio de tragos")
        println("3. Estadisticas")
        println("4. Volver al menu principal")
        when (readLine()?.toIntOrNull()) {
            1 -> servicioRepositoriosProvider().repositorioClientes()
            2 -> servicioRepositoriosProvider().repositorioTragos()
            3 -> servicioEstadisticasProvider().estadisticas()
            4 -> menuProvider().mostrar()
            else -> println("Opción no válida.")
        }
    }
}