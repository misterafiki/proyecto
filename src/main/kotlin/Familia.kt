/**
 * Clase que representa una familia en el sistema.
 *
 * @property id ID de la familia.
 * @property descripcion Descripción de la familia.
 */
class Familia {
    var id: Int
    var descripcion: String

    constructor(id: Int, descripcion: String) {
        this.id = id
        this.descripcion = descripcion
    }
}