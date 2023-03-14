package presentation


import domain.di.servicioClienteProvider
import domain.di.servicioDueñoProvider
import kotlin.system.exitProcess

class Menu() {
    fun mostrar() {
        println("Bienvenido a BolicheGo!")
        println("¿Eres dueño o cliente?")
        println("1. Dueño")
        println("2. Cliente")
        println("3. Salir")
        println("4. Volver al menú principal")

        when (readLine()?.toIntOrNull()) {
            1 -> servicioDueñoProvider().opcionDueño()
            2 -> servicioClienteProvider().opcionCliente()
            3 -> opciónSalir()
            4 -> mostrar()
            else -> println("Opción no válida.")
        }
    }

    fun volverMenuPrincipal() {
        mostrar()
    }

    fun opciónSalir() {
        println("Gracias por usar BolicheGo. ¡Vuelva pronto!")
        exitProcess(0)
    }
}

