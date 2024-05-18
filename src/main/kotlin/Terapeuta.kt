class Terapeuta {
    var email: String=""
    var pass:String=""
    var nombre:String=""
    //var apellidos:String=""
    var grupo:Int=1
    var metodologia:Metodologia=Metodologia.METODO1

    constructor( email: String, pass: String, nombre: String, grupo: Int, metodologia: Metodologia) {
        this.email = email
        this.pass = pass
        this.nombre = nombre
        this.grupo = grupo
        this.metodologia = metodologia
    }

    constructor(email: String, nombre: String, grupo: Int, metodologia: Metodologia) {
        this.email = email
        this.nombre = nombre
        this.grupo = grupo
        this.metodologia = metodologia
    }

    constructor(email: String, pass: String, nombre: String) {
        this.email = email
        this.pass = pass
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Terapeuta( email='$email', nombre='$nombre', grupo=$grupo, metodologia=$metodologia)"
    }


}