package BBDD
import Grupo
interface GrupoDAO {
    fun getAllGrupo(): List<Grupo>
    fun insertGrupo(grupo: Grupo): Boolean
    fun updateFamilia(id:Int): Boolean
    fun deleteFamilia(id: Int): Boolean
}