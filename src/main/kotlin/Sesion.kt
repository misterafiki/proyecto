class Sesion {
    var id:Int=0
    //var familia:Familia
    //var grupo:Grupo
    var familia:Int
    var grupo:Int
    lateinit var emocion:Emociones

    /*constructor(id: Int, familia: Familia, grupo: Grupo, emociones: Emociones) {
        this.id = id
        this.familia = familia
        this.grupo = grupo
        this.emociones = emociones
    }*/

    constructor(id: Int, familia: Int, grupo: Int, emocion: Emociones) {
        this.id = id
        this.familia = familia
        this.grupo = grupo
        this.emocion = emocion
    }

    constructor(familia: Int, grupo: Int, emocion: Emociones) {
        this.familia = familia
        this.grupo = grupo
        this.emocion = emocion
    }

    constructor(id: Int, familia: Int, grupo: Int, emocion: String?){
        this.familia = familia
        this.grupo = grupo
        //this.emocion = emocion
    }


}