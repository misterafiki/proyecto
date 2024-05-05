import java.sql.SQLException

class IndividuoDAOImpl : IndividuoDAO {

    private val conexion = ConexionBD()

    override fun getIndividuoByEmail(email: String): Individuo? {
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
                    rs.getString("familia"),
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


    override fun getIdByEmail(email: String): Int? {
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

    override fun getAllIndividuos(): List<Individuo> {
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
                        rs.getString("familia"),
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

    override fun insertIndividuo(individuo: Individuo): Boolean {
        var result = false
        try {
            conexion.conectar()
            val query = "INSERT INTO individuo (email, nombre, apellidos, familia, rol) VALUES (?, ?, ?, ?, ?)"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, individuo.email)
            ps?.setString(2, individuo.nombre)
            ps?.setString(3, individuo.apellidos)
            ps?.setString(4, individuo.familia)
            ps?.setString(5, individuo.rol.toString())
            result = ps?.executeUpdate() == 1
            ps?.close()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            conexion.desconectar()
        }
        return result
    }

    override fun updatePassIndividuo(individuo: Individuo): Boolean {
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

    override fun updateRole(individuo: Individuo): Boolean {
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

    override fun deleteIndividuo(individuo: Individuo): Boolean {
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
}
