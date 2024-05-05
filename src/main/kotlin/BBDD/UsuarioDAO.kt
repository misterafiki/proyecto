interface UsuarioDAO {
    fun getUsuarioByEmail(email: String): Usuario?
    fun getIdByEmail(email: String): Int?
    fun getAllUsuarios(): List<Usuario>
    fun insertUsuario(usuario: Usuario): Boolean
    fun updateUsuario(usuario: Usuario): Boolean
    fun updateRole(usuario: Usuario): Boolean
    fun deleteUsuario(usuario: Usuario): Boolean
}