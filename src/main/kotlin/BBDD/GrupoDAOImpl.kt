package BBDD
import ConexionBD
import Grupo
class GrupoDAOImpl:GrupoDAO {
    private val conexion=ConexionBD()
    override fun getAllGrupo(): List<Grupo> {
        conexion.conectar()
        val query = "SELECT * FROM grupos"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val grupo = arrayListOf<Grupo>()
        while (rs?.next() == true) {
            grupo.add(Grupo(rs.getInt("id"), rs.getString("nombre")))
        }
        st?.close()
        conexion.desconectar()
        return grupo
    }

    override fun getGrupoByid(id: Int): Grupo? {
        conexion.conectar()
        val query = "SELECT * FROM grupos WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var grupo: Grupo? = null
        if (rs?.next() == true) {
            grupo = Grupo(rs.getInt("id"),rs.getString("nombre"))
        }
        ps?.close()
        conexion.desconectar()
        return grupo
    }

    override fun insertGrupo(grupo: Grupo): Boolean {
        conexion.conectar()
        val query = "INSERT INTO grupo (id,nombre ) VALUES (?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, grupo.id)
        ps?.setString(2, grupo.nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateGrupo(grupo: Grupo): Boolean {
        conexion.conectar()
        val query = "UPDATE grupos SET nombre = ? WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, grupo.id)
        ps?.setString(2, grupo.nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteGrupo(id: Int): Boolean {
        conexion.conectar()
        val query = "DELETE FROM grupos WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }


}