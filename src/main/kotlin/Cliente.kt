import java.util.*

class Cliente(private val scanner: Scanner) {
    var esVip = false
    var entrada: Entrada? = null
    var tragos = mutableListOf<String>()
    var nombre = String()
    var saldo = 0.0

    fun ingresar() {
        println("Ingrese los datos del cliente:")
        println("Nombre:")
        nombre = scanner.nextLine()
        println("Edad:")
        val edad = scanner.nextInt()
        scanner.nextLine()
        if (edad >= 18) {
            println("Saldo:")
            saldo = scanner.nextDouble()
            scanner.nextLine()
            println("¿Es VIP? (s/n):")
            val esVip = scanner.nextLine().equals("s", true)
            this.esVip = esVip
            if (esVip) {
                entrada = Entrada.VIP()
                saldo -= entrada!!.precio
            } else {
                println("¿Compró una entrada general? (s/n):")
                val comproEntrada = scanner.nextLine().equals("s", true)
                if (comproEntrada) {
                    entrada = Entrada.General()
                    saldo -= entrada!!.precio
                } else {
                    println("Debe comprar una entrada para ingresar.")
                }
            }
        } else {
            println("El cliente es menor de edad y no puede ingresar al boliche.")
        }
    }

    fun tragosComprados(): Int {
        return tragos.size
    }

    fun comprarTrago(nombreTrago: String) {
        val trago = Trago().tragosInfo[nombreTrago]
        if (trago != null && trago.cantidadDisponible > 0 && saldo >= trago.precio) {
            tragos.add(nombreTrago)
            trago.cantidadDisponible -= 1
            saldo -= trago.precio
        } else {
            throw Exception("La bebida no está disponible o no tienes suficiente saldo")
        }
    }
}
