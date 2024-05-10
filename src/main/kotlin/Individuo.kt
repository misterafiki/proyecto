class Individuo {
    val email: String
    val pass: String
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