package logica

import BBDD.SesionDAOImpl
import Sesion

class ControladorSesion {
    companion object {

        private val SesionDAO = SesionDAOImpl()

        fun obtenerSesionPorId(id: Int): Sesion? {
            return ControladorSesion.SesionDAO.getSesionsPorId(id)
        }

        fun obtenerTodasSesiones(): List<Sesion> {
            return ControladorSesion.SesionDAO.getAllSesions()
        }

        fun eliminarSesion(id: Int): Boolean {
            return ControladorSesion.SesionDAO.deleteSesion(id)
        }

        fun actualizarGrupo(sesion: Sesion): Boolean {
            return ControladorSesion.SesionDAO.updateSesion(sesion)
        }
    }
}