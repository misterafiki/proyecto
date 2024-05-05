package logica
import BBDD.*
import Grupo
import Metodologia
import Terapeuta
import java.util.*

class ControladorTerapeuta () {
    companion object {
        private val TerapeuraDAO = TerapeutaDAOImpl()

        fun registrar(email: String, pass: String, nombre: String) {
            val usuarioNuevo = Terapeuta(email, pass, nombre,)
            TerapeuraDAO.insertTerapeuta(usuarioNuevo)
        }

        fun login(email: String, password: String) {
            val usuario = TerapeuraDAO.getTerapeutaByEmail(email)
            if (usuario != null && usuario.pass == password) {

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

        fun cambiarGrupo(email: String, nuevoGrup:String ) {
            val usuario = TerapeuraDAO.getTerapeutaByEmail(email)
            usuario?.let {
                val grupEnum = when (nuevoGrup.uppercase(Locale.getDefault())) {
                    "GRUPO1" ->  Grupo.GRUPO1
                    "GRUPO2" -> Grupo.GRUPO2
                    "GRUPO3" -> Grupo.GRUPO3
                    else -> throw IllegalArgumentException("Metodologia desconocido: $nuevoGrup")
                }
                it.id_grupos = grupEnum
                TerapeuraDAO.updateGrupo(usuario)
        }

        fun cambiarMetodo(email: String, nuevoMeto:String) {
            val usuario = TerapeuraDAO.getTerapeutaByEmail(email)
            usuario?.let {
                val metoEnum = when (nuevoMeto.uppercase(Locale.getDefault())) {
                    "METO1" ->  Metodologia.METO1
                    "METO2" ->  Metodologia.METO2
                    "METO3" -> Metodologia.METO3
                    else -> throw IllegalArgumentException("Metodologia desconocido: $nuevoMeto")
                }
                it.id_metodologia = metoEnum
               TerapeuraDAO.updateMetodo(usuario)
            }
        }
    }
}