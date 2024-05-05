import java.util.SimpleTimeZone

class Usuario {
    var email: String=""
    var pass:String=""
    var nombre:String=""
    var apellidos:String=""
    var id_familia:Int=0
    var id_rol:Int=0

    constructor( email: String, pass: String, nombre: String, apellidos: String, id_familia: Int, id_rol: Int) {
        this.email = email
        this.pass = pass
        this.nombre = nombre
        this.apellidos = apellidos
        this.id_familia = id_familia
        this.id_rol = id_rol
    }

    constructor( email: String, nombre: String, apellidos: String, id_familia: Int, id_rol: Int) {
        this.email = email
        this.nombre = nombre
        this.apellidos = apellidos
        this.id_familia = id_familia
        this.id_rol = id_rol
    }


    override fun toString(): String {
        return "Usuario(email='$email', nombre='$nombre', apellidos='$apellidos', id_familia=$id_familia, id_rol=$id_rol)"
    }

}