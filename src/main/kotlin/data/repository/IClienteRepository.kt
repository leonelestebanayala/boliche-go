package data.repository

import data.model.Cliente

interface IClienteRepository {
    fun crearCliente()
    fun eliminarCliente()
    fun actualizarCliente()
    fun buscarCliente(): Cliente?
    fun cantidadClientes() : Int
}