package BBDD

import ConexionBD
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
        ps?.setInt(5, usuario.id_metodologia)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateTerapeuta(usuario: Terapeuta): Boolean {
        conexion.conectar()
        val query = "UPDATE usuarios SET pass = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.pass)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    //Comprobacion de la base detos como llamar a los grupos y metdologias
    override fun updateGrupo(usuario: Terapeuta): Boolean {
        conexion.conectar()
        var grupaux = usuario.id_grupos
        val grupo = when (grupaux) {
            1 -> "ESTANDAR"
            2 -> "ADMINISTRADOR"
            3 -> "AMBOS"
            else -> throw IllegalArgumentException("Grupo desconocido: $grupaux")
        }
        val query = "UPDATE usuarios SET id_grupo = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1,grupo)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateMetodo(usuario: Terapeuta): Boolean {
        conexion.conectar()
        var metpaux = usuario.id_grupos
        val metodo = when (metpaux) {
            1 -> "ESTANDAR"
            2 -> "ADMINISTRADOR"
            3 -> "AMBOS"
            else -> throw IllegalArgumentException("Grupo desconocido: $metpaux")
        }
        val query = "UPDATE usuarios SET id_metodologia = ? WHERE email = ?"
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