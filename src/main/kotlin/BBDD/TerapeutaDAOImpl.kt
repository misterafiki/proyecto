package BBDD

import ConexionBD
import Metodologia
import Terapeuta

/**
 * Implementación de TerapeutaDAO para gestionar las operaciones CRUD de la entidad Terapeuta en la base de datos.
 *
 * @constructor Crea una instancia de TerapeutaDAOImpl.
 */
class TerapeutaDAOImpl : TerapeutaDAO {

    private val conexion = ConexionBD()

    /**
     * Obtiene un terapeuta por su correo electrónico.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para encontrar
     * un terapeuta con el correo electrónico especificado y devuelve el terapeuta encontrado,
     * o `null` si no se encuentra ningún terapeuta con ese correo.
     *
     * @param email El correo electrónico del terapeuta a buscar.
     * @return El terapeuta con el correo electrónico especificado, o `null` si no se encuentra.
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
     * Obtiene el ID de un terapeuta por su correo electrónico.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para encontrar
     * el ID de un terapeuta con el correo electrónico especificado y devuelve el ID encontrado,
     * o `null` si no se encuentra ningún terapeuta con ese correo.
     *
     * @param email El correo electrónico del terapeuta a buscar.
     * @return El ID del terapeuta con el correo electrónico especificado, o `null` si no se encuentra.
     */
    override fun getIdByEmail(email: String): Int? {
        conexion.conectar()
        val query = "SELECT * FROM terapeuta WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, email)
        val rs = ps?.executeQuery()
        var id: Int? = null
        if (rs?.next() == true) {
            id = rs.getInt("id")
        }
        ps?.close()
        conexion.desconectar()
        return id
    }

    /**
     * Obtiene una lista de todos los terapeutas.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para obtener todos los terapeutas
     * y devuelve una lista de objetos `Terapeuta` que representan a cada terapeuta en la base de datos.
     *
     * @return Una lista de todos los terapeutas en la base de datos.
     */
    override fun getAllTerapeuta(): List<Terapeuta> {
        conexion.conectar()
        val query = "SELECT * FROM terapeuta"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val usuarios = arrayListOf<Terapeuta>()
        while (rs?.next() == true) {
            usuarios.add(Terapeuta(rs.getString("email"), rs.getString("pass"), rs.getString("nombre")))
        }
        st?.close()
        conexion.desconectar()
        return usuarios
    }

    /**
     * Inserta un nuevo terapeuta en la base de datos.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para insertar un nuevo
     * terapeuta con los detalles proporcionados y devuelve un valor booleano que indica si
     * la inserción fue exitosa.
     *
     * @param usuario El objeto `Terapeuta` que contiene los detalles del terapeuta a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    override fun insertTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "INSERT INTO terapeuta (email, pass, nombre, grupo, metodologia) VALUES (?,?,?,?,?)"
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
     * Actualiza la contraseña de un terapeuta en la base de datos.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para actualizar la contraseña
     * de un terapeuta identificado por su correo electrónico y devuelve un valor booleano que indica
     * si la actualización fue exitosa.
     *
     * @param usuario El objeto `Terapeuta` que contiene el correo electrónico y la nueva contraseña del terapeuta.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
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
     * Actualiza el grupo de un terapeuta en la base de datos.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para actualizar el grupo
     * de un terapeuta identificado por su correo electrónico y devuelve un valor booleano que indica
     * si la actualización fue exitosa.
     *
     * @param usuario El objeto `Terapeuta` que contiene el correo electrónico y el nuevo grupo del terapeuta.
     *                No debe ser nulo.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     * @throws IllegalArgumentException si el parámetro `usuario` es nulo.
     */
    override fun updateGrupo(usuario: Terapeuta?): Boolean {
        requireNotNull(usuario) { "El parámetro usuario no puede ser nulo" }

        conexion.conectar()
        val query = "UPDATE terapeuta SET grupo = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, usuario.grupo)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }


    /**
     * Actualiza la metodología de un terapeuta en la base de datos.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para actualizar la metodología
     * de un terapeuta identificado por su correo electrónico y devuelve un valor booleano que indica
     * si la actualización fue exitosa.
     *
     * @param usuario El objeto `Terapeuta` que contiene el correo electrónico y la nueva metodología del terapeuta.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     * @throws IllegalArgumentException si la metodología proporcionada no es válida.
     */
    override fun updateMetodo(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val metodo = when (usuario.metodologia) {
            Metodologia.METODO1 -> "METODO1"
            Metodologia.METODO2 -> "METODO2"
            Metodologia.METODO3 -> "METODO3"
            else -> throw IllegalArgumentException("Metodología desconocida: ${usuario.metodologia}")
        }
        val query = "UPDATE terapeuta SET metodologia = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, metodo)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }


    /**
     * Elimina un terapeuta de la base de datos.
     *
     * Esta función se conecta a la base de datos, ejecuta una consulta para eliminar un terapeuta
     * identificado por su correo electrónico y devuelve un valor booleano que indica si la eliminación
     * fue exitosa.
     *
     * @param usuario El objeto `Terapeuta` que contiene el correo electrónico del terapeuta a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
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