package BBDD

import ConexionBD
import Sesion

class SesionDAOImpl:SesionDAO {
    private val conexion = ConexionBD()
    override fun getAllSesions(): List<Sesion> {
        TODO("Not yet implemented")
    }

    override fun insertSesion(sesion: Sesion): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateSesion(sesion: Sesion): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteSesion(sesion: Sesion): Boolean {
        TODO("Not yet implemented")
    }
}