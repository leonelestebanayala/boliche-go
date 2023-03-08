sealed class Entrada(val precio: Double) {
    class VIP : Entrada(20.0)
    class General : Entrada(15.0)
}
