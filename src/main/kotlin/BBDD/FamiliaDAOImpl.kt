package BBDD

import ConexionBD
import Familia
import java.sql.SQLException

/**
 * Implementación de la interfaz [FamiliaDAO] que interactúa con la base de datos.
 *
 * @property conexion Objeto de conexión a la base de datos.
 */
class FamiliaDAOImpl : FamiliaDAO {

    private val conexion = ConexionBD()

    /**
     * Obtiene todas las familias desde la base de datos.
     *
     * @return Lista de objetos [Familia].
     */
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

    /**
     * Inserta una nueva familia en la base de datos.
     *
     * @param familia Objeto [Familia] a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
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

    /**
     * Actualiza la descripción de una familia existente en la base de datos.
     *
     * @param familia Objeto [Familia] con la descripción actualizada.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
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

    /**
     * Elimina una familia de la base de datos.
     *
     * @param familia Objeto [Familia] a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
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