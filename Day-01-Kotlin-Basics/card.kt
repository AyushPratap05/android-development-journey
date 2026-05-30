fun main() {

    println("========================================")
    println("     WELCOME TO PROFILE CARD MAKER      ")
    println("========================================")
    println()

    // ---- Collecting Basic Info ----
    print("Enter your Full Name: ")
    val name = readLine() ?: "Unknown"

    print("Enter your Age: ")
    val age = readLine()?.toIntOrNull() ?: 0

    print("Enter your City: ")
    val city = readLine() ?: "Unknown"

    print("Enter your State: ")
    val state = readLine() ?: "Unknown"

    print("Enter your College/University: ")
    val college = readLine() ?: "Unknown"

    print("Enter your Degree (e.g. B.Tech CSE): ")
    val degree = readLine() ?: "Unknown"

    print("Enter your Graduation Year: ")
    val graduationYear = readLine()?.toIntOrNull() ?: 2024

    // ---- Skills ----
    print("Enter your Primary Skill (e.g. Android Development): ")
    val primarySkill = readLine() ?: "Unknown"

    print("Enter your Secondary Skill (e.g. Machine Learning): ")
    val secondarySkill = readLine() ?: "Unknown"

    print("Enter your Target Role: ")
    val targetRole = readLine() ?: "Software Developer"

    // ---- Goals ----
    print("Enter your Expected Salary in LPA (e.g. 12): ")
    val expectedSalary = readLine()?.toIntOrNull() ?: 0

    print("Enter current Learning Day (e.g. 1): ")
    val currentDay = readLine()?.toIntOrNull() ?: 1

    print("Do you have a Laptop? (yes/no): ")
    val hasLaptop = readLine()?.lowercase() == "yes"

    print("Are you open to Relocation? (yes/no): ")
    val openToRelocation = readLine()?.lowercase() == "yes"

    // ---- Calculations ----
    val remainingDays = 60 - currentDay
    val experienceYears = 2026 - graduationYear
    val laptopStatus = if (hasLaptop) "Yes ✅" else "No ❌"
    val relocationStatus = if (openToRelocation) "Yes ✅" else "No ❌"
    val progressBar = buildProgressBar(currentDay, 60)

    // ---- Display Profile Card ----
    println()
    println()
    println("╔══════════════════════════════════════════════╗")
    println("║        🎯 DEVELOPER PROFILE CARD             ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  PERSONAL INFORMATION                        ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  Name          : $name")
    println("║  Age           : $age years")
    println("║  Location      : $city, $state")
    println("╠══════════════════════════════════════════════╣")
    println("║  EDUCATION                                   ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  Degree        : $degree")
    println("║  College       : $college")
    println("║  Graduated     : $graduationYear")
    println("║  Experience    : $experienceYears year(s) since graduation")
    println("╠══════════════════════════════════════════════╣")
    println("║  SKILLS & TARGET                             ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  Primary Skill : $primarySkill")
    println("║  Second Skill  : $secondarySkill")
    println("║  Target Role   : $targetRole")
    println("╠══════════════════════════════════════════════╣")
    println("║  CAREER GOALS                                ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  Expected CTC  : Rs.$expectedSalary LPA")
    println("║  Has Laptop    : $laptopStatus")
    println("║  Relocation    : $relocationStatus")
    println("╠══════════════════════════════════════════════╣")
    println("║  60-DAY JOURNEY PROGRESS                     ║")
    println("╠══════════════════════════════════════════════╣")
    println("║  Current Day   : Day $currentDay of 60")
    println("║  Days Left     : $remainingDays days remaining")
    println("║  Progress      : $progressBar")
    println("╠══════════════════════════════════════════════╣")
    println("║  STATUS        : Day $currentDay Complete!!")
    println("║  MESSAGE       : Keep Going! You are on track!!")
    println("╚══════════════════════════════════════════════╝")
}

fun buildProgressBar(current: Int, total: Int): String {
    val percentage = (current.toDouble() / total * 100).toInt()
    val filled = percentage / 5
    val empty = 20 - filled
    val bar = "█".repeat(filled) + "░".repeat(empty)
    return "[$bar] $percentage%"
}