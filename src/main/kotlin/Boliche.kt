import java.util.Scanner

class Boliche {

    var clientes = mutableListOf<Cliente>()
    var tragos = Trago().tragos
    var stockTragos = mutableMapOf<String, Int>()

    init {
        Trago().tragosInfo.forEach { (nombre, info) ->
            stockTragos[nombre] = info.cantidadDisponible
        }
    }
    fun cantidadClientes(): Int {
        return clientes.size
    }

    fun cantidadTragosVendidos(): Int {
        return clientes.sumOf { it.tragosComprados() }
    }

    fun mostrarStockTragos() {
        println("El stock actual de tragos es:")
        stockTragos.forEach { (nombre, cantidad) ->
            println("$nombre: $cantidad unidades")
        }
    }

    fun recaudacionTotal(): Double {
        return clientes.sumOf { recaudacionPorCliente(it) }
    }
    fun recaudacionPorCliente(cliente: Cliente): Double {
        val entrada = cliente.entrada ?: return 0.0
        val precioEntrada = entrada.precio
        val precioTragos = cliente.tragos.sumOf { nombreTrago ->
            Trago().tragosInfo[nombreTrago]?.precio ?: 0.0
        }
        return precioEntrada + precioTragos
    }
}