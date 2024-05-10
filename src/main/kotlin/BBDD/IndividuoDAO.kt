interface IndividuoDAO {
    fun getIndividuoByEmail(email: String): Individuo?
    fun getIdByEmail(email: String): Int?
    fun getAllIndividuos(): List<Individuo>
    fun insertIndividuo(individuo: Individuo): Boolean
    fun updatePassIndividuo(individuo: Individuo): Boolean
    fun updateRole(individuo: Individuo): Boolean
    fun deleteIndividuo(individuo: Individuo): Boolean
    fun deleteAllIndividuos(id: Int): Boolean
}