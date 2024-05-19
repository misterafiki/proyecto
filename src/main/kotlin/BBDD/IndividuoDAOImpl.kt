import java.sql.SQLException

/**
 * Implementación de la interfaz [IndividuoDAO] que interactúa con la base de datos.
 *
 * @property conexion Objeto de conexión a la base de datos.
 */
class IndividuoDAOImpl : IndividuoDAO {

    private val conexion = ConexionBD()

    /**
     * Obtiene un [Individuo] por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del individuo.
     * @return Objeto [Individuo] si se encuentra en la base de datos, o `null` si no existe.
     */
    override fun obtenerIndividuoPorEmail(email: String): Individuo? {
        var individuo: Individuo? = null

        try {
            conexion.conectar()
            val query = "SELECT * FROM individuo WHERE email = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, email)
            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                val rolString = rs.getString("rol")
                val rol = when (rolString) {
                    "PADRE" -> Rol.PADRE
                    "HIJO" -> Rol.HIJO
                    "OTRO" -> Rol.OTRO
                    else -> throw IllegalArgumentException("Rol desconocido: $rolString")
                }
                individuo = Individuo(
                    rs.getString("email"),
                    rs.getString("pass"),  // Asumiendo que el pass viene de la base de datos también
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getInt("familia"),
                    rol
                )
            }
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return individuo
    }

    /**
     * Obtiene el ID de un [Individuo] por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del individuo.
     * @return ID del individuo si se encuentra en la base de datos, o `null` si no existe.
     */
    override fun obternerIdPorEmail(email: String): Int? {
        var id: Int? = null

        try {
            conexion.conectar()
            val query = "SELECT id FROM individuo WHERE email = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, email)
            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                id = rs.getInt("id")
            }
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return id
    }

    /**
     * Obtiene todos los individuos desde la base de datos.
     *
     * @return Lista de objetos [Individuo].
     */
    override fun obtenerTodosIndividuos(): List<Individuo> {
        val individuos = mutableListOf<Individuo>()

        try {
            conexion.conectar()
            val query = "SELECT * FROM individuo"
            val st = conexion.getStatement()
            val rs = st?.executeQuery(query)
            while (rs?.next() == true) {
                val rol = when (rs.getString("rol")) {
                    "PADRE" -> Rol.PADRE
                    "HIJO" -> Rol.HIJO
                    "OTRO" -> Rol.OTRO
                    else -> throw IllegalArgumentException("Rol desconocido: ${rs.getString("rol")}")
                }
                individuos.add(
                    Individuo(
                        rs.getString("email"),
                        rs.getString("pass"), // Asumiendo que el pass viene de la base de datos también
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("familia"),
                        rol
                    )
                )
            }
            st?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }

        return individuos
    }

    /**
     * Inserta un nuevo [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    override fun insertarIndividuo(individuo: Individuo): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "INSERT INTO individuo (email, pass, nombre, apellidos, familia, rol) VALUES (?, ?, ?, ?, ?, ?)"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, individuo.email)
            ps?.setString(2, individuo.pass)
            ps?.setString(3, individuo.nombre)
            ps?.setString(4, individuo.apellidos)
            ps?.setInt(5, individuo.familia)
            ps?.setString(6, individuo.rol.toString())
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
     * Actualiza la contraseña de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con la nueva contraseña.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    override fun actualizarPassIndividuo(individuo: Individuo): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "UPDATE individuo SET pass = ? WHERE email = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, individuo.pass)
            ps?.setString(2, individuo.email)
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
     * Actualiza el rol de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con el nuevo rol.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    override fun actualizarRol(individuo: Individuo): Boolean {
        var result = false

        try {
            conexion.conectar()
            var rolaux = individuo.rol
            val rol = when (rolaux) {
                Rol.PADRE -> "PADRE"
                Rol.HIJO -> "HIJO"
                Rol.OTRO -> "OTROS"
                else -> throw IllegalArgumentException("Rol desconocido: $rolaux")
            }
            val query = "UPDATE individuo SET rol = ? WHERE email = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, rol)
            ps?.setString(2, individuo.email)
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
     * Elimina un [Individuo] de la base de datos.
     *
     * @param individuo Objeto [Individuo] a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    override fun borrarIndividuo(individuo: Individuo): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "DELETE FROM individuo WHERE email = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, individuo.email)
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
     * Elimina todos los individuos asociados a una familia de la base de datos.
     *
     * @param id ID de la familia cuyos individuos se eliminarán.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    override fun borrarTodosIndividuos(id: Int): Boolean {
        var result = false

        try {
            conexion.conectar()
            val query = "DELETE FROM individuo WHERE familia = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setInt(1, id)
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
