package domain

import data.di.clienteRepositorioProvider
import data.di.tragoRepositorioProvider
import presentation.di.menuProvider

class ServicioRepositorios {

    fun repositorioClientes() {
        var opcion: Int? = null

        do {
            println("¿Desea realizar alguna operación en el repositorio de clientes?")
            println("1. Crear cliente")
            println("2. Eliminar cliente")
            println("3. Actualizar cliente")
            println("4. Buscar cliente")
            println("5. Salir")
            println("6. Volver al menú principal")
            opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> {
                    clienteRepositorioProvider().crearCliente()
                    opcion = null
                }
                2 -> {
                    clienteRepositorioProvider().eliminarCliente()
                    opcion = null
                }
                3 -> {
                    clienteRepositorioProvider().actualizarCliente()
                    opcion = null
                }
                4 -> {
                    clienteRepositorioProvider().buscarCliente()
                    opcion = null
                }
                5 -> menuProvider().opciónSalir()
                6 -> menuProvider().volverMenuPrincipal()
                else -> println("Opción no válida.")
            }
        } while (opcion != 5 && opcion != 6)
    }


    fun repositorioTragos() {
        var opcion: Int? = null

        do {
            println("¿Desea realizar alguna operación en el repositorio de tragos?")
            println("1. Crear trago")
            println("2. Eliminar trago")
            println("3. Actualizar trago")
            println("4. Buscar trago")
            println("5. Salir")
            println("6. Volver al menú principal")
            opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> {
                    tragoRepositorioProvider().crearTrago()
                }
                2 -> {
                    tragoRepositorioProvider().eliminarTrago()
                    opcion = null
                }
                3 -> {
                    tragoRepositorioProvider().actualizarTrago()
                    opcion = null
                }
                4 -> {
                    tragoRepositorioProvider().buscarTrago()
                    opcion = null
                }
                5 -> menuProvider().opciónSalir()
                6 -> menuProvider().volverMenuPrincipal()
                else -> println("Opción no válida.")
            }
        } while (opcion != 5 && opcion != 6)
    }

}