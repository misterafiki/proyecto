package BBDD

import ConexionBD
import Familia

class FamiliaDAOImpl:FamiliaDAO {
    private val conexion = ConexionBD()
    override fun getAllFamilias(): List<Familia> {
        conexion.conectar()
        val query = "SELECT * FROM familia"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val familia = arrayListOf<Familia>()
        while (rs?.next() == true) {
            familia.add(Familia(rs.getInt("id"), rs.getString("descripcion") ))
        }
        st?.close()
        conexion.desconectar()
        return familia
    }

    override fun insertFamilia(familia: Familia): Boolean {
        conexion.conectar()
        val query = "INSERT INTO familia (descripcion ) VALUES (?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, familia.descripcion)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateFamilia(familia: Familia): Boolean {
        conexion.conectar()
        val query = "UPDATE familia SET descipcion = ? WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, familia.descripcion)
        ps?.setInt(2, familia.id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteFamilia(familia: Familia): Boolean {
        conexion.conectar()
        val query = "DELETE FROM familia WHERE id = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, familia.id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

}