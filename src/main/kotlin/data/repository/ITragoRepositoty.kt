package data.repository

import data.model.Cliente

interface ITragoRepositoty {

    fun crearTrago()
    fun eliminarTrago()
    fun actualizarTrago()
    fun buscarTrago()

}