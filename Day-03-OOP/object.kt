// class 
class person{
    var name:String = " "
    var age: Int = 0
    var city: String = ""
    // methood inside function
    fun introduce(){
        println("hi i am $name, $age years old from $city")

    }
    fun isadult():Boolean{
        return age>=18
    }
}
// object 
fun main (){
val person1 = person()
person1.name = "Ayush"
person1.age = 23
person1.city = "Orai"
person1.introduce()
println(person1.isadult())
}