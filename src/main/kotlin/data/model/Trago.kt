package data.model

data class Trago(val nombre: String, val marca: String, val precio: Double, var stock: Int) {
    fun tragosComprados(): Int {
        return this.stock - 1
    }
}
