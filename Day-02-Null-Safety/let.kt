fun main(){
     val userInput: String? = readLine()
    userInput?.let {
        println("You entered: $it")
        println("Length: ${it.length}")
    } ?: println("No input provided")

}