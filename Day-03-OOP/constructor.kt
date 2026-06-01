class student (
    val name:String,
    val rollno: Int,
    var cgpa: Double,
    val branch: String="CSE"
){
    init{
        println(" student created: $name(Roll No : $rollno)")
        require(cgpa in 0.0..10.0){"cgpa must between 0 and 10"}
    }


    fun displayinfo(){
        println( """
            ┌─────────────────────────┐
            │  Name   : $name
            │  Roll   : $rollno
            │  Branch : $branch
            │  CGPA   : $cgpa
            └─────────────────────────┘
        """.trimIndent())
        
    }
    
    fun updateCgpa(newCgpa: Double) {
        cgpa = newCgpa
        println("CGPA updated to $newCgpa")
    }
}
fun main() {
    // Creating objects with primary constructor
    val s1 = student("Ayush", 101, 8.5)
    val s2 = student("Priya", 102, 9.2, "IT")
    val s3 = student("Rahul", 103, 7.8, "ECE")

    s1.displayinfo()
    s2.displayinfo()

    s1.updateCgpa(8.9)
    s1.displayinfo()
}