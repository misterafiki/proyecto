package BBDD

import ConexionBD
import Familia
import java.sql.SQLException

class FamiliaDAOImpl : FamiliaDAO {

    private val conexion = ConexionBD()

    override fun getAllFamilias(): List<Familia> {
        val familias = mutableListOf<Familia>()

        try {
            conexion.conectar()
            val query = "SELECT * FROM familia"
            val ps = conexion.getPreparedStatement(query)
            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                familias.add(
                    Familia(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                    )
                )
            }
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return familias
    }

    override fun insertFamilia(familia: Familia): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "INSERT INTO familia (id, descripcion) VALUES (?, ?)"
            val ps = conexion.getPreparedStatement(query)
            ps?.setInt(1, familia.id)
            ps?.setString(2, familia.descripcion)
            result = ps?.executeUpdate() == 1
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return result
    }

    override fun updateFamilia(familia: Familia): Boolean {
        var result = false

        conexion.conectar()
        try {
            val query = "UPDATE familia SET descripcion = ? WHERE id = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, familia.descripcion)
            ps?.setInt(2, familia.id)
            result = ps?.executeUpdate() == 1
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return result
    }

    override fun deleteFamilia(familia: Familia): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "DELETE FROM familia WHERE id = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setInt(1, familia.id)
            result = ps?.executeUpdate() == 1
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return result
    }
}