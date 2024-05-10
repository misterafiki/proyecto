package BBDD

import ConexionBD
import Sesion
import Emociones

class SesionDAOImpl:SesionDAO {
    private val conexion = ConexionBD()
    override fun getAllSesions(): List<Sesion> {
        conexion.conectar()
        val query = "SELECT * FROM sesion"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val grupo = arrayListOf<Sesion>()
        while (rs?.next() == true) {
            grupo.add(Sesion(rs.getInt("id"),rs.getInt("familia"),rs.getInt("grupo"),rs.getString("emocion")))
        }
        st?.close()
        conexion.desconectar()
        return grupo
    }

    override fun insertSesion(sesion: Sesion): Boolean {
        conexion.conectar()
        val query = "INSERT INTO sesion (id,familia,grupo,emocion ) VALUES (?,?,?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, sesion.id)
        ps?.setInt(2, sesion.familia)
        ps?.setInt(2, sesion.grupo)
        ps?.setString(2, sesion.emocion.toString())
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1

        /*conexion.conectar()
        val query = "INSERT INTO sesion (id,familia,grupo,emocion ) VALUES (?,?,?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, sesion.id)
        ps?.setInt(2, sesion.familia)
        ps?.setInt(2, sesion.grupo)
        ps?.setString(2, sesion.emocion.toString())
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
*/


    }

    override fun updateSesion(sesion: Sesion): Boolean {
        conexion.conectar()
        val query = "UPDATE sesion SET emocion = ? WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, sesion.emocion.toString())
        ps?.setInt(2, sesion.id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteSesion(id: Int): Boolean {
        conexion.conectar()
        val query = "DELETE FROM sesion WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun getSesionsPorId(id:Int):Sesion {
        conexion.conectar()
        val query = "SELECT * FROM sesion WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var sesion: Sesion? = null
        if (rs?.next() == true) {
            sesion = Sesion(rs.getInt("id"),rs.getInt("familia"),rs.getInt("grupo"),rs.getString("emocion"))
        }
        ps?.close()
        conexion.desconectar()
        return sesion
    }
    }
}