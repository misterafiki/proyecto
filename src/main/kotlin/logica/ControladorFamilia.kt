package logica

import BBDD.FamiliaDAOImpl
import Familia
import IndividuoDAOImpl

/**
 * Clase que actúa como controlador para las operaciones relacionadas con las familias.
 */
class ControladorFamilia {
    companion object {

        private val familiaDAOImpl = FamiliaDAOImpl()
        private val individuoDAOImpl = IndividuoDAOImpl()

        /**
         * Registra una nueva familia en la base de datos.
         *
         * @param id ID de la familia.
         * @param descripcion Descripción de la familia.
         */
        fun registrar(id: Int, descripcion: String) {
            val familia = Familia(id, descripcion)
            familiaDAOImpl.insertFamilia(familia)
        }

        /**
         * Obtiene todas las familias desde la base de datos.
         *
         * @return Lista de objetos [Familia].
         */
        fun obtenerFamilias(): List<Familia> {
            return familiaDAOImpl.getAllFamilias()
        }

        /**
         * Actualiza los datos de una familia existente en la base de datos.
         *
         * @param familia Objeto [Familia] con los datos actualizados.
         * @return `true` si la actualización fue exitosa, `false` en caso contrario.
         */
        fun actualizarFamilia(familia: Familia): Boolean {
            return familiaDAOImpl.updateFamilia(familia)
        }

        /**
         * Elimina una familia de la base de datos y también elimina todos los individuos asociados a ella.
         *
         * @param familia Objeto [Familia] a eliminar.
         * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
         */
        fun eliminarFamilia(familia: Familia): Boolean {
            individuoDAOImpl.deleteAllIndividuos(familia.id)
            return familiaDAOImpl.deleteFamilia(familia)
        }
    }
}
