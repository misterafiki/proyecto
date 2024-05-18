package logica
import BBDD.*
import Terapeuta
import java.util.*

class ControladorTerapeuta () {
    companion object{
        private val TerapeuraDAO = TerapeutaDAOImpl()

        fun registrar(email: String, pass:String, nombre: String) {
            val usuarioNuevo = Terapeuta(email,pass,nombre,)
            TerapeuraDAO.insertTerapeuta(usuarioNuevo)
        }

        fun login(email: String, password: String) {
            val usuario = TerapeuraDAO.getTerapeutaByEmail(email)
            if (usuario != null && usuario.pass == password){

            }

        }

        fun obtenerTodosTerapeuras(): List<Terapeuta> {
            return TerapeuraDAO.getAllTerapeutas()
        }

        fun obtenerTerapeuraPorEmail(email: String): Terapeuta? {
            return TerapeuraDAO.getTerapeutaByEmail(email)
        }

        fun eliminarTerapeura(usuario: Terapeuta): Boolean {
            return TerapeuraDAO.deleteTerapeuta(usuario)
        }

        fun actualizarTerapeura(usuario: Terapeuta): Boolean {
            return TerapeuraDAO.updateTerapeuta(usuario)
        }

        fun cambiarGrupo(usuario: Terapeuta):Boolean {
            return TerapeuraDAO.updateGrupo(usuario)
        }
        fun cambiarMetodo(usuario: Terapeuta):Boolean {
            return TerapeuraDAO.updateGrupo(usuario)
        }


    }
}