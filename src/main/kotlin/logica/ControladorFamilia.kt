package logica

import BBDD.FamiliaDAOImpl
import Familia

class ControladorFamilia {
    private val familiaDAO = FamiliaDAOImpl()
    fun obtenerfamilias(): List<Familia> {
        return familiaDAO.getAllFamilias()
    }
    fun eliminarfamilia(familia: Familia): Boolean {
        return familiaDAO.deleteFamilia(familia)
    }

    fun añadirfamilia(descripcion:String) {
        val familiaNueva = Familia(descripcion)
        familiaDAO.insertFamilia(familiaNueva)
    }

    fun actualizarfamilia(familia: Familia): Boolean {
        return familiaDAO.updateFamilia(familia)
    }
}
