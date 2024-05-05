class UsuarioDAOImpl: UsuarioDAO{

    private val conexion = ConexionBD()

    override fun getUsuarioByEmail(email: String): Usuario? {
        conexion.conectar()
        val query = "SELECT * FROM usuarios WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, email)
        val rs = ps?.executeQuery()
        var usuario: Usuario? = null
        if (rs?.next() == true) {
            var rolaux = rs.getString("rol")
            val rol = when (rolaux) {
                "ESTANDAR" -> Rol.ESTANDAR
                "ADMINISTRADOR" -> Rol.ADMINISTRADOR
                "AMBOS" -> Rol.AMBOS
                else -> throw IllegalArgumentException("Rol desconocido: $rolaux")
            }
            usuario = Usuario(rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"),rs.getInt("edad"),rs.getString("claveAcceso"),rol)

        }
        ps?.close()
        conexion.desconectar()
        return usuario
    }

    override fun getIdByEmail(email: String): Int? {
        conexion.conectar()
        val query = "SELECT * FROM usuarios WHERE email = ?"
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

    override fun getAllUsuarios(): List<Usuario> {
        conexion.conectar()
        val query = "SELECT * FROM usuarios"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val usuario = arrayListOf<Usuario>()
        while (rs?.next() == true) {
            var rolaux = rs.getString("rol")
            val rol = when (rolaux) {
                "ESTANDAR" -> Rol.ESTANDAR
                "ADMINISTRADOR" -> Rol.ADMINISTRADOR
                "AMBOS" -> Rol.AMBOS
                else -> throw IllegalArgumentException("Rol desconocido: $rolaux")
            }
            usuario.add(Usuario(rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"),rs.getInt("edad"),rs.getString("claveAcceso"),rol))
        }
        st?.close()
        conexion.desconectar()
        return usuario
    }

    override fun insertUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val query = "INSERT INTO usuarios (email, nombre, apellidos, edad,claveAcceso,rol ) VALUES (?, ?,?,?,?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        ps?.setString(2, usuario.nombre)
        ps?.setString(3, usuario.apellido)
        ps?.setInt(4, usuario.edad)
        ps?.setString(5, usuario.password)
        ps?.setString(6, usuario.rol.toString())
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val query = "UPDATE usuarios SET edad = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, usuario.edad)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
    override fun updateRole(usuario: Usuario): Boolean {
        conexion.conectar()
        var rolaux = usuario.rol
        val rol = when (rolaux) {
            Rol.ESTANDAR -> "ESTANDAR"
            Rol.ADMINISTRADOR -> "ADMINISTRADOR"
            Rol.AMBOS -> "AMBOS"
            else -> throw IllegalArgumentException("Rol desconocido: $rolaux")
        }
        val query = "UPDATE usuarios SET rol = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1,rol)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val query = "DELETE FROM usuarios WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}