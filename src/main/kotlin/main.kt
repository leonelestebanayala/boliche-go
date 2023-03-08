import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val boliche = Boliche()

    println("Bienvenido al boliche. ¿Cuántos clientes ingresarán?")
    val cantidadClientes = scanner.nextInt()
    scanner.nextLine()

    for (i in 1..cantidadClientes) {
        val cliente = Cliente(scanner)
        cliente.ingresar()
        if (cliente.entrada != null) {
            boliche.clientes.add(cliente)
        }
    }

    println("La carta de tragos es:")
    val trago = Trago()
    trago.menu()

    for (cliente in boliche.clientes) {
        println("¿Cuántos tragos quiere comprar ${cliente.nombre}?")
        val cantidadTragos = scanner.nextInt()
        scanner.nextLine()
        for (i in 1..cantidadTragos) {
            println("Ingrese el nombre del trago:")
            val trago = scanner.nextLine()
            if (boliche.tragos.contains(trago)) {
                if (boliche.stockTragos.getOrDefault(trago, 0) > 0) {
                    cliente.comprarTrago(trago)
                    boliche.stockTragos[trago] = boliche.stockTragos.getOrDefault(trago, 0) - 1
                } else {
                    println("Lo siento, no hay stock de $trago.")
                }
            } else {
                println("El trago ingresado no existe en el boliche.")
            }
        }
        println("Su saldo es de ${cliente.saldo}")
    }

    println("La cantidad de clientes es: ${boliche.cantidadClientes()}")
    println("La cantidad de tragos vendidos es: ${boliche.cantidadTragosVendidos()}")
    println("La recaudación total es: ${boliche.recaudacionTotal()}")
    boliche.mostrarStockTragos()
}