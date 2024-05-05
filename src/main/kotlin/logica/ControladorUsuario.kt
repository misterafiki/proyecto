import java.util.*

class ControladorUsuario () {
    companion object {
        private val usuarioDAO = UsuarioDAOImpl()

        fun registrar(email: String, nombre: String, apellido: String, edad: Int, password: String) {
            val usuarioNuevo = Usuario(email, nombre, apellido, edad, password)
            usuarioDAO.insertUsuario(usuarioNuevo)
        }

        fun login(email: String, password: String): Rol? {
            val usuario = usuarioDAO.getUsuarioByEmail(email)
            var rol: Rol? =  null
            if (usuario != null && usuario.password == password){
               rol = usuario.rol
            }
            return rol
        }

        fun obtenerTodosUsuarios(): List<Usuario> {
            return usuarioDAO.getAllUsuarios()
        }

        fun obtenerUsuarioPorEmail(email: String): Usuario? {
            return usuarioDAO.getUsuarioByEmail(email)
        }

        fun eliminarUsuario(usuario: Usuario): Boolean {
            return usuarioDAO.deleteUsuario(usuario)
        }

        fun actualizarUsuario(usuario: Usuario): Boolean {
            return usuarioDAO.updateUsuario(usuario)
        }

        fun cambiarRol(email: String, nuevoRol: String) {
            val usuario = usuarioDAO.getUsuarioByEmail(email)
            usuario?.let {
                val rolEnum = when (nuevoRol.uppercase(Locale.getDefault())) {
                    "ESTANDAR" -> Rol.ESTANDAR
                    "ADMINISTRADOR" -> Rol.ADMINISTRADOR
                    "AMBOS" -> Rol.AMBOS
                    else -> throw IllegalArgumentException("Rol desconocido: $nuevoRol")
                }
                it.rol = rolEnum
                usuarioDAO.updateRole(it)
            }
        }
    }
}