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
abstract class BaseSystem(val systemName: String){
    protected val students = mutableListOf<Student>() // use of protected ?

    abstract fun generateReport()

    fun getTotalCount() = students.size

    fun displayHeader() {
        println("╔══════════════════════════════════════════════╗")
        println("║     $systemName")
        println("╚══════════════════════════════════════════════╝")
     }

}


// Main Mgmt Class 

class StudentManagementSystem:
BaseSystem("  🎓 STUDENT MANAGEMENT SYSTEM      ")
Manageable{
    companion object{
        private var lastId = 100 
        fun generateId() = ++lastId
    }

// CRUD OPR

override fun add(student : Student){
    students.add(student)
    println("✅ Added: ${student.name} (ID: ${student.id})")
}

override fun remove(id:Int):Boolean{
    val student = findById(id)
    return if(student!=null){
        students.remove(student)
        println("🗑 Removed: ${student.name}")
        true
    }else{println("❌ Student with ID $id not found")
            false
        }

}
override fun findById(id:Int):Student?{
    return students.find{it.id == id}
}
}

