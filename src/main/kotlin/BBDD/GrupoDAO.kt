package BBDD
import Grupo
interface GrupoDAO {
    fun getAllGrupo(): List<Grupo>
    fun getGrupoByid(id: Int): Grupo?
    fun insertGrupo(grupo: Grupo): Boolean
    fun updateGrupo(grupo: Grupo): Boolean
    fun deleteGrupo(id: Int): Boolean
}