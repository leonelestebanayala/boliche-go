class Trago {
    data class TragoInfo(val nombre: String, val precio: Double, var cantidadDisponible: Int)

    val tragosInfo = mapOf(
        "Cerveza" to TragoInfo("Cerveza", 4.0, 100),
        "Ron" to TragoInfo("Ron", 8.0, 50),
        "Vodka" to TragoInfo("Vodka", 7.0, 30),
        "Whisky" to TragoInfo("Whisky", 12.0, 10)
    )

    val tragos = tragosInfo.keys.toList()

    fun menu() {
        println("Menu:")
        for ((nombre, info) in tragosInfo) {
            println("$nombre ${info.precio}$")
        }
    }
}