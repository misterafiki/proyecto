package BBDD

import ConexionBD
import Grupo
import Metodologia
import Terapeuta

class TerapeutaDAOImpl : TerapeutaDAO {

    private val conexion = ConexionBD()
    override fun getTerapeutaByEmail(email: String): Terapeuta? {
        conexion.conectar()
        val query = "SELECT * FROM usuarios WHERE email = ?"
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

    override fun getIdByEmail(email: String): Int? {
        conexion.conectar()
        val query = "SELECT * FROM terapeutas WHERE email = ?"
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

    override fun getAllTerapeutas(): List<Terapeuta> {
        conexion.conectar()
        val query = "SELECT * FROM terapeutas"
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

    override fun insertTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "INSERT INTO terapeutas (email,pass, nombre,id_grupos,id_metodologia ) VALUES (?,?,?,?,?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        ps?.setString(2, usuario.pass)
        ps?.setString(3, usuario.nombre)
        ps?.setInt(4, usuario.id_grupos)
        ps?.setString(5, usuario.id_metodologia.toString())
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "UPDATE terapeutas SET pass = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.pass)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }


    override fun updateGrupo(usuario: Terapeuta?): Boolean {
        conexion.conectar()
        val query = "UPDATE terapeuta SET id_grupo = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1,usuario?.id_grupos!!)
        ps?.setString(2, usuario?.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateMetodo(usuario: Terapeuta): Boolean {
        conexion.conectar()
        var metpaux = usuario.id_metodologia
        val metodo = when (metpaux) {
            // llama a la enum de metodologias
             Metodologia.METODO1 -> "METODO1"
             Metodologia.METODO2 -> "METODO2"
             Metodologia.METODO3 -> "METODO3"
            else -> throw IllegalArgumentException("Metodologia desconocido: $metpaux")
        }
        val query = "UPDATE terapeuta SET id_metodologia = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1,metodo)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "DELETE FROM terapeutas WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

}