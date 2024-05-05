package BBDD

import Terapeuta

interface TerapeutaDAO {
    fun getTerapeutaByEmail(email: String): Terapeuta?
    fun getIdByEmail(email: String): Int?
    fun getAllTerapeutas(): List<Terapeuta>
    fun insertTerapeuta(usuario: Terapeuta): Boolean
    fun updateTerapeuta(usuario: Terapeuta): Boolean
    fun updateGrupo(usuario: Terapeuta): Boolean
    fun updateMetodo(usuario: Terapeuta): Boolean
    fun deleteTerapeuta(usuario: Terapeuta): Boolean
}