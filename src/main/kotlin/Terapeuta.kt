class Terapeuta {
    var email: String=""
    var pass:String=""
    var nombre:String=""
    //var apellidos:String=""
    var id_grupos:Int=0
    var id_metodologia:Int=0

    constructor( email: String, pass: String, nombre: String, id_grupos: Int, id_metodologia: Int) {
        this.id = id
        this.email = email
        this.pass = pass
        this.nombre = nombre
        this.id_grupos = id_grupos
        this.id_metodologia = id_metodologia
    }

    constructoremail: String, nombre: String, id_grupos: Int, id_metodologia: Int) {
        this.email = email
        this.nombre = nombre
        this.id_grupos = id_grupos
        this.id_metodologia = id_metodologia
    }

    constructor(email: String, pass: String, nombre: String) {
        this.email = email
        this.pass = pass
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Terapeuta( email='$email', nombre='$nombre', id_grupos=$id_grupos, id_metodologia=$id_metodologia)"
    }


}