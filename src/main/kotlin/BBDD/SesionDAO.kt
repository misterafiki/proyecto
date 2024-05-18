package BBDD

import Sesion

interface SesionDAO {
    fun getAllSesions(): List<Sesion>
    fun getSesionsPorId(id:Int):Sesion
    fun insertSesion(sesion: Sesion): Boolean
    fun updateSesion(sesion: Sesion): Boolean
    fun deleteSesion(id: Int): Boolean
}