package BBDD

import Sesion

interface SesionDAO {
    fun getAllSesions(): List<Sesion>
    fun insertSesion(sesion: Sesion): Boolean
    fun updateSesion(sesion: Sesion): Boolean
    fun deleteSesion(sesion: Sesion): Boolean
}