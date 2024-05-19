class Grupo {
    var id:Int
    var nombre:String

    constructor(id: Int, nombre: String) {
        this.id = id
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Grupo(id=$id, nombre='$nombre')"
    }

}