// data classes 

data class Student (
    val id:Int,
    val name: String,
    val branch: String,
    val year: Int,
    var cgpa: Double,
    var isPlaced: Boolean = false,
    var placedCompany: String = "N/A"
)
 

// interface 

interface Manageable{
    fun add(student: Student)
    fun remove(id:Int):Boolean
    fun findById(id:Int): Student?
    fun displayAll()
}