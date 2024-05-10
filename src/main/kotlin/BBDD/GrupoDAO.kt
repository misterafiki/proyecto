package BBDD
import Grupo
interface GrupoDAO {
    fun getAllGrupo(): List<Grupo>
    fun getGrupoByid(email: String): Grupo?
    fun insertGrupo(grupo: Grupo): Boolean
    fun updateGrupo(id:Int): Boolean
    fun deleteGrupo(id: Int): Boolean
}