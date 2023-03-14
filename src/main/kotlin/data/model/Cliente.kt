package data.model

data class Cliente(val nombre: String, val edad: Int, var saldo: Double, val ID: Number) {

    var tragosComprados: Long = 0

    fun esMayorDeEdad(): Boolean {
        return edad >= 18
    }

    fun esVIP(): Boolean {
        return saldo >= 50.0
    }

    fun tieneEntrada(): Boolean {
        return saldo >= 20.0
    }
}