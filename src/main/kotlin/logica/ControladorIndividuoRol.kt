import java.util.*

class ControladorIndividuoRol() {
    companion object {

        private val usuarioDAO = IndividuoDAOImpl()

        fun registrar(email: String, pass: String, nombre: String, apellidos: String, familia: String, rol: Rol) {
            val usuarioNuevo = Individuo(email, pass, nombre, apellidos, familia, rol)
            usuarioDAO.insertIndividuo(usuarioNuevo)
        }

        fun login(email: String, password: String): Rol? {
            val usuario = usuarioDAO.getIndividuoByEmail(email)
            var rol: Rol? = null
            if (usuario != null && usuario.pass == password) {
                rol = usuario.rol
            }
            return rol
        }

        fun obtenerTodosUsuarios(): List<Individuo> {
            return usuarioDAO.getAllIndividuos()
        }

        fun obtenerUsuarioPorEmail(email: String): Individuo? {
            return usuarioDAO.getIndividuoByEmail(email)
        }

        fun eliminarUsuario(usuario: Individuo): Boolean {
            return usuarioDAO.deleteIndividuo(usuario)
        }

        fun actualizarUsuario(usuario: Individuo): Boolean {
            return usuarioDAO.updatePassIndividuo(usuario)
        }

        fun cambiarRol(email: String, nuevoRol: String) {
            val usuario = usuarioDAO.getIndividuoByEmail(email)
            if (usuario != null) {
                val rolEnum = when (nuevoRol.uppercase(Locale.getDefault())) {
                    "PADRE" -> Rol.PADRE
                    "HIJO" -> Rol.HIJO
                    "OTRO" -> Rol.OTRO
                    else -> throw IllegalArgumentException("Rol desconocido: $nuevoRol")
                }
                usuario.rol = rolEnum
                usuarioDAO.updateRole(usuario)
            }
        }
    }
}