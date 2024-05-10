class Sesion {
    var id:Int
    //var familia:Familia
    //var grupo:Grupo
    var familia:Int
    var grupo:Int

    var emociones:Emociones

    /*constructor(id: Int, familia: Familia, grupo: Grupo, emociones: Emociones) {
        this.id = id
        this.familia = familia
        this.grupo = grupo
        this.emociones = emociones
    }*/

    constructor(id: Int, familia: Int, grupo: Int, emociones: Emociones) {
        this.id = id
        this.familia = familia
        this.grupo = grupo
        this.emociones = emociones
    }

}