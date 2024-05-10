package logica

import BBDD.FamiliaDAOImpl
import Familia
import IndividuoDAOImpl

class ControladorFamilia {
    companion object {

        private val familiaDAOImpl = FamiliaDAOImpl()
        private val individuoDAOImpl = IndividuoDAOImpl()

        fun registrar(id: Int, descripcion: String) {
            val familia = Familia(id, descripcion)
            familiaDAOImpl.insertFamilia(familia)
        }

        fun obtenerFamilias(): List<Familia> {
            return familiaDAOImpl.getAllFamilias()
        }

        fun actualizarFamilia(familia: Familia): Boolean {
            return familiaDAOImpl.updateFamilia(familia)
        }

        fun eliminarFamilia(familia: Familia): Boolean {
            individuoDAOImpl.deleteAllIndividuos(familia.id)
            return familiaDAOImpl.deleteFamilia(familia)
        }
    }
}
