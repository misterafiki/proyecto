package BBDD

import Familia

interface FamiliaDAO {
    fun getAllFamilias(): List<Familia>
    fun insertFamilia(sesion: Familia): Boolean
    fun updateFamilia(sesion: Familia): Boolean
    fun deleteFamilia(sesion: Familia): Boolean
}