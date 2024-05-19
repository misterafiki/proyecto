/**
 * Clase que representa a un individuo en el sistema.
 *
 * @property email Dirección de correo electrónico del individuo.
 * @property pass Contraseña del individuo.
 * @property nombre Nombre del individuo (puede ser nulo).
 * @property apellidos Apellidos del individuo (pueden ser nulos).
 * @property familia ID de la familia a la que pertenece el individuo.
 * @property rol Rol del individuo (PADRE, HIJO, OTRO).
 */
class Individuo {
    val email: String
    var pass: String
    val nombre: String?
    val apellidos: String?
    val familia: Int
    var rol: Rol

    constructor(email: String, pass: String, nombre: String?, apellidos: String?, familia: Int, rol: Rol) {
        this.email = email
        this.pass = pass
        this.nombre = nombre
        this.apellidos = apellidos
        this.familia = familia
        this.rol = rol
    }

    override fun toString(): String {
        return "Individuo(email='$email', pass='$pass', nombre=$nombre, apellidos=$apellidos, familia='$familia', rol=$rol)"
    }
}