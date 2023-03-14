package data.model

import java.net.IDN

class Boliche {


    var recaudacion = 0.0
    fun agregarVenta(precioTotal: Double) {
        recaudacion += precioTotal
    }

    fun obtenerRecaudacionTotal(): Double {
        return recaudacion
    }
}