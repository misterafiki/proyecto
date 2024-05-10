package BBDD

import ConexionBD
import Sesion

class SesionDAOImpl:SesionDAO {
    private val conexion = ConexionBD()
    override fun getAllSesions(): List<Sesion> {
        conexion.conectar()
        val query = "SELECT * FROM sesion"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val grupo = arrayListOf<Sesion>()
        while (rs?.next() == true) {
            grupo.add(Sesion(rs.getInt("id"),rs.getString("familia"),rs.getString("grupo"),rs.getString("emocion")))
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
        ps?.setString(2, sesion.familia)
        ps?.setString(2, sesion.grupo)
        ps?.setString(2, sesion.emocion)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateSesion(sesion: Sesion): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteSesion(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSesionsPorId(id:Int): Sesion {
        TODO("Not yet implemented")
    }
}