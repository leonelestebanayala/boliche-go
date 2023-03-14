package domain

import data.di.bolicheProvider
import data.di.clienteRepositorioProvider
import data.di.tragoRepositorioProvider
import domain.di.servicioDueñoProvider

class ServicioEstadisticas {
    fun estadisticas(){
        println("Estadísticas del boliche:")
        println("Cantidad de clientes: ${clienteRepositorioProvider().cantidadClientes()}")
        println("Stock de bebidas: ${tragoRepositorioProvider().stockBebidas()}")
        println("Recaudación total: ${bolicheProvider().obtenerRecaudacionTotal()}")
        println("Cantidad de tragos vendidos: ${tragoRepositorioProvider().cantidadTragosVendidos()}")
        servicioDueñoProvider().opcionDueño()
    }

}