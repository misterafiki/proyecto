package logica

import BBDD.GrupoDAOImpl
import Grupo
import java.util.*

class ControladorGrupo {
    companion object {

        private val GrupoDAO = GrupoDAOImpl()

        fun obtenerGrupoPorId(id: Int): Grupo? {
            return ControladorGrupo.GrupoDAO.getGrupoByid(id)
        }

        fun obtenerTodogrupo(): List<Grupo> {
            return ControladorGrupo.GrupoDAO.getAllGrupo()
        }

        fun eliminarGrupo(id: Int): Boolean {
            return ControladorGrupo.GrupoDAO.deleteGrupo(id)
        }

        fun actualizarGrupo(grupo: Grupo): Boolean {
            return ControladorGrupo.GrupoDAO.updateGrupo(grupo)
        }
    }
}