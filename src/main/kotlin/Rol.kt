/**
 * Enumeración que representa los roles posibles para un individuo.
 *
 * @property valor Valor asociado al rol (PADRE, HIJO, OTRO).
 */
enum class Rol(var valor: String) {
    PADRE("PADRE"),
    HIJO("HIJO"),
    OTRO("OTRO")
}