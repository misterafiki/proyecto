package logica

import BBDD.GrupoDAOImpl
import Grupo
import java.util.*

class ControladorGrupo {
    companion object {
        private val GrupoDAO = GrupoDAOImpl()
        private fun obtenerTodogrupo(): List<Grupo> {
            return ControladorGrupo.GrupoDAO.getAllGrupo()
        }

        fun obtenerGrupoPorId(id: String): Grupo? {
            return ControladorGrupo.GrupoDAO.getGrupoByid(id)
        }

        fun eliminarGrupo(id: Int): Boolean {
            return ControladorGrupo.GrupoDAO.deleteGrupo(id)
        }

        fun actualizarGrupo(id: Int): Boolean {
            return ControladorGrupo.GrupoDAO.updateGrupo(id)
        }
    }
}