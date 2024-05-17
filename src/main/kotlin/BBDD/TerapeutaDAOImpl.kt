package BBDD

import ConexionBD
import Metodologia
import Terapeuta

/**
 * Terapeuta d a o impl
 *
 * @constructor Create empty Terapeuta d a o impl
 */
class TerapeutaDAOImpl : TerapeutaDAO {

    private val conexion = ConexionBD()

    /**
     * Get terapeuta by email
     *
     * @param email
     * @return
     */
    override fun getTerapeutaByEmail(email: String): Terapeuta? {
        conexion.conectar()
        val query = "SELECT * FROM terapeuta WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, email)
        val rs = ps?.executeQuery()
        var usuario: Terapeuta? = null
        if (rs?.next() == true) {
            usuario = Terapeuta(rs.getString("email"),rs.getString("pass"), rs.getString("nombre"))
        }
        ps?.close()
        conexion.desconectar()
        return usuario
    }

    /**
     * Get id by email
     *
     * @param email
     * @return
     */
    override fun getIdByEmail(email: String): Int? {
        conexion.conectar()
        val query = "SELECT * FROM terapeuta WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, email)
        val rs = ps?.executeQuery()
        var id: Int? =0
        if (rs?.next() == true) {
            id = rs.getInt("id")
        }
        ps?.close()
        conexion.desconectar()
        return id
    }

    /**
     * Get all terapeutas
     *
     * @return
     */
    override fun getAllTerapeutas(): List<Terapeuta> {
        conexion.conectar()
        val query = "SELECT * FROM terapeuta"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val usuario = arrayListOf<Terapeuta>()
        while (rs?.next() == true) {
            usuario.add(Terapeuta(rs.getString("email"), rs.getString("pass"), rs.getString("nombre")))
        }
        st?.close()
        conexion.desconectar()
        return usuario
    }

    /**
     * Insert terapeuta
     *
     * @param usuario
     * @return
     */
    override fun insertTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "INSERT INTO terapeuta (email,pass, nombre,grupo,metodologia ) VALUES (?,?,?,?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        ps?.setString(2, usuario.pass)
        ps?.setString(3, usuario.nombre)
        ps?.setInt(4, usuario.grupo)
        ps?.setString(5, usuario.metodologia.toString())
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    /**
     * Update terapeuta
     *
     * @param usuario
     * @return
     */
    override fun updateTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "UPDATE terapeuta SET pass = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.pass)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }


    /**
     * Update grupo
     *
     * @param usuario
     * @return
     */
    override fun updateGrupo(usuario: Terapeuta?): Boolean {
        conexion.conectar()
        val query = "UPDATE terapeuta SET grupo = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1,usuario?.grupo!!)
        ps?.setString(2, usuario?.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    /**
     * Update metodo
     *
     * @param usuario
     * @return
     */
    override fun updateMetodo(usuario: Terapeuta): Boolean {
        conexion.conectar()
        var metpaux = usuario.metodologia
        val metodo = when (metpaux) {
            // llama a la enum de metodologias
             Metodologia.METODO1 -> "METODO1"
             Metodologia.METODO2 -> "METODO2"
             Metodologia.METODO3 -> "METODO3"
            else -> throw IllegalArgumentException("Metodologia desconocido: $metpaux")
        }
        val query = "UPDATE terapeuta SET metodologia = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1,metodo)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    /**
     * Delete terapeuta
     *
     * @param usuario
     * @return
     */
    override fun deleteTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "DELETE FROM terapeuta WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

}