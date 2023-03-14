package data.repository

import data.model.Cliente
import data.model.Entrada
import data.di.bolicheProvider

class ClienteRepositorio : IClienteRepository{
    private val clientes = mutableListOf<Cliente>()
    fun getClientes(): MutableList<Cliente>{
        return clientes
    }

    override fun crearCliente() {
        print("Nombre del cliente: ")
        val nombre = readLine() ?: ""
        print("Edad del cliente: ")
        val edad = readLine()?.toIntOrNull() ?: 0
        print("Saldo del cliente: ")
        val saldo = readLine()?.toDoubleOrNull() ?: 0.0
        val ID = clientes.size
        val cliente = Cliente(nombre, edad, saldo, ID = ID)
        clientes.add(cliente)
        println("data.model.Cliente creado exitosamente.")
        println("El ID es $ID")
    }

    override fun eliminarCliente() {
        print("Ingrese el ID del cliente a eliminar: ")
        val id = readLine()?.toLongOrNull() ?: return
        val cliente = clientes.find { it.ID == id }
        if (cliente != null) {
            clientes.remove(cliente)
            println("data.model.Cliente eliminado exitosamente.")
        } else {
            println("data.model.Cliente no encontrado.")
        }
    }

    override fun actualizarCliente() {
        print("Ingrese el ID del cliente a actualizar: ")
        val id = readLine()?.toLongOrNull() ?: return
        val index = clientes.indexOfFirst { it.ID == id }
        if (index >= 0) {
            val cliente = clientes[index]
            print("Nuevo nombre del cliente (${cliente.nombre}): ")
            val nuevoNombre = readLine() ?: cliente.nombre
            print("Nueva edad del cliente (${cliente.edad}): ")
            val nuevaEdad = readLine()?.toIntOrNull() ?: cliente.edad
            print("Nuevo saldo del cliente (${cliente.saldo}): ")
            val nuevoSaldo = readLine()?.toDoubleOrNull() ?: cliente.saldo
            val nuevoID = clientes.size
            val nuevoCliente = Cliente(nuevoNombre, nuevaEdad, nuevoSaldo, nuevoID)
            clientes[index] = nuevoCliente
            println("data.model.Cliente actualizado exitosamente.")
        } else {
            println("data.model.Cliente no encontrado.")
        }
    }
    override fun buscarCliente(): Cliente? {
        print("Ingrese el ID del cliente a buscar: ")
        val id = readLine()?.toLongOrNull()
        val cliente = clientes.find { it.ID == id }
        if (cliente != null) {
            println("data.model.Cliente encontrado:")
            println(cliente)
            return cliente
        }
        println("data.model.Cliente no encontrado.")
        return null
    }

    override fun cantidadClientes(): Int {
        return clientes.size
    }
    fun ingresarDatos() {

        print("Nombre: ")
        val nombre = readLine() ?: ""
        print("Edad: ")
        val edad = readLine()?.toIntOrNull() ?: 0
        print("Saldo: ")
        val saldo = readLine()?.toDoubleOrNull() ?: 0.0

        val cliente = Cliente(
            nombre = nombre,
            edad = edad,
            saldo = saldo,
            ID = clientes.size
        )
        ingresarCliente(cliente)
    }

    fun ingresarCliente(cliente: Cliente) {
        if (cliente.esMayorDeEdad() && (cliente.esVIP() || !cliente.tieneEntrada())) {
            clientes.add(cliente)
            if (cliente.esVIP()) {
                bolicheProvider().agregarVenta(Entrada.VIP.precio)
            } else {
                bolicheProvider().agregarVenta(Entrada.GENERAL.precio)
            }
            println("data.model.Cliente ingresado exitosamente.")
        } else {
            println("No se puede ingresar al cliente.")
        }
    }
}
