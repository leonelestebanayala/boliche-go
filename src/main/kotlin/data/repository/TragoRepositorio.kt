package data.repository

import data.model.Trago
import data.di.bolicheProvider
import presentation.Menu

class TragoRepositorio: ITragoRepositoty {
    val tragos = mutableListOf<Trago>()

    override fun crearTrago() {
        print("Nombre del trago: ")
        val nombre = readLine() ?: ""
        print("Precio del trago: ")
        val precio = readLine()?.toDoubleOrNull() ?: 0.0
        print("Nombre del marca: ")
        val marca = readLine() ?: ""
        print("Nombre del stock: ")
        val stock = readLine() ?.toIntOrNull()?: 0
        val trago = Trago(nombre = nombre, precio = precio, marca = marca, stock = stock)
        tragos.add(trago)
        println("data.model.Trago creado exitosamente.")
    }
    override fun eliminarTrago() {
        print("Ingrese el nombre del trago a eliminar: ")
        val nombre = readLine() ?: return
        val trago = tragos.find { it.nombre == nombre }
        if (trago != null) {
            tragos.remove(trago)
            println("data.model.Trago eliminado exitosamente.")
        } else {
            println("No se encontró el trago con nombre $nombre.")
        }
    }

    override fun actualizarTrago() {
        print("Ingrese el nombre del trago a actualizar: ")
        val nombre = readLine() ?: return
        val trago = tragos.find { it.nombre == nombre }
        if (trago != null) {
            print("Nuevo nombre del trago (${trago.nombre}): ")
            val nuevoNombre = readLine() ?: trago.nombre
            print("Nuevo precio del trago (${trago.precio}): ")
            val nuevoPrecio = readLine()?.toDoubleOrNull() ?: trago.precio
            print("Nueva marca del trago (${trago.marca}): ")
            val nuevaMarca = readLine() ?: trago.marca
            print("Nuevo stock del trago (${trago.stock}): ")
            val nuevoStock = readLine()?.toIntOrNull() ?: trago.stock
            val tragoActualizado = Trago(nuevoNombre, nuevaMarca, nuevoPrecio, nuevoStock)
            tragos.remove(trago)
            tragos.add(tragoActualizado)
            println("data.model.Trago actualizado exitosamente.")
        } else {
            println("data.model.Trago no encontrado.")
        }
    }
    override fun buscarTrago() {
        print("Ingrese el nombre del trago a buscar: ")
        val nombre = readLine() ?: return
        val trago = tragos.find { it.nombre == nombre }
        if (trago != null) {
            println("data.model.Trago encontrado: $trago")
        } else {
            println("data.model.Trago no encontrado.")
        }
    }

    fun stockBebidas(): Int {
        return tragos.sumOf { it.stock }
    }
    fun cantidadTragosVendidos(): Int {
        return tragos.sumOf { it.tragosComprados() }
    }

    fun comprarTrago() {
        print("Ingrese el nombre del cliente: ")
        val nombreCliente = readLine() ?: ""
        val cliente = ClienteRepositorio().getClientes().find { it.nombre == nombreCliente }

        print("Ingrese el nombre del trago: ")
        val nombreTrago = readLine() ?: ""
        val trago = tragos.find { it.nombre == nombreTrago }

        print("Ingrese la cantidad de tragos a comprar: ")
        val cantidad = readLine()?.toIntOrNull() ?: 0

        if (cliente != null && trago != null) {
            if (cliente.saldo >= trago.precio * cantidad && trago.stock >= cantidad) {
                cliente.saldo -= trago.precio * cantidad
                trago.stock -= cantidad
                bolicheProvider().agregarVenta(trago.precio * cantidad)
                cliente.tragosComprados += cantidad
                println("Compra realizada con éxito.")
            } else {
                println("No se puede realizar la compra.")
            }
        } else {
            println("data.model.Cliente o trago no encontrado.")
        }
        Menu().mostrar()
    }
}