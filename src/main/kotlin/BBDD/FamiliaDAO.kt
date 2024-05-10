package BBDD

import Familia

interface FamiliaDAO {
    fun getAllFamilias(): List<Familia>
    fun insertFamilia(familia: Familia): Boolean
    fun updateFamilia(familia: Familia): Boolean
    fun deleteFamilia(familia: Familia): Boolean
}