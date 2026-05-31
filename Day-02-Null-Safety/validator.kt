fun main() {
    println("╔══════════════════════════════════════╗")
    println("║      SMART INPUT VALIDATOR APP       ║")
    println("╚══════════════════════════════════════╝")
    println()

    // ── Collect Inputs ──
    print("Enter Full Name    : ")
    val name = readLine() ?: ""

    print("Enter Age          : ")
    val ageInput = readLine() ?: ""

    print("Enter Email        : ")
    val email = readLine() ?: ""

    print("Enter Phone Number : ")
    val phone = readLine() ?: ""

    print("Enter CGPA (0-10)  : ")
    val cgpaInput = readLine() ?: ""

    print("Enter City         : ")
    val city = readLine() ?: ""

    // ── Validate Each Input ──
    val nameResult  = validateName(name)
    val ageResult   = validateAge(ageInput)
    val emailResult = validateEmail(email)
    val phoneResult = validatePhone(phone)
    val cgpaResult  = validateCgpa(cgpaInput)
    val cityResult  = validateCity(city)

    // ── Count Results ──
    val results = listOf(
        nameResult, ageResult, emailResult,
        phoneResult, cgpaResult, cityResult
    )
    val passed = results.count { it.isValid }
    val failed = results.count { !it.isValid }

    // ── Display Results ──
    println()
    println("╔══════════════════════════════════════╗")
    println("║         VALIDATION RESULTS           ║")
    println("╠══════════════════════════════════════╣")
    println("║  Name    : ${formatResult(nameResult)}")
    println("║  Age     : ${formatResult(ageResult)}")
    println("║  Email   : ${formatResult(emailResult)}")
    println("║  Phone   : ${formatResult(phoneResult)}")
    println("║  CGPA    : ${formatResult(cgpaResult)}")
    println("║  City    : ${formatResult(cityResult)}")
    println("╠══════════════════════════════════════╣")
    println("║  Passed  : $passed/6")               
    println("║  Failed  : $failed/6")               
    println("║  Status  : ${getOverallStatus(passed)}")
    println("╚══════════════════════════════════════╝")
}

// ── Data class for validation result ──
data class ValidationResult(
    val isValid: Boolean,
    val message: String
)

// ── Validation Functions ──

fun validateName(name: String): ValidationResult {
    return when {
        name.isBlank()      -> ValidationResult(false, "Name cannot be empty")
        name.length < 2     -> ValidationResult(false, "Name too short")
        name.length > 50    -> ValidationResult(false, "Name too long")
        name.any { it.isDigit() } -> ValidationResult(false, "Name cannot have numbers")
        else                -> ValidationResult(true, "Valid ✅")
    }
}

fun validateAge(ageInput: String): ValidationResult {
    val age = ageInput.toIntOrNull()
    return when {
        age == null     -> ValidationResult(false, "Age must be a number")
        age < 16        -> ValidationResult(false, "Age too young (min 16)")
        age > 60        -> ValidationResult(false, "Age too high (max 60)")
        else            -> ValidationResult(true, "Valid ✅ ($age years)")
    }
}

fun validateEmail(email: String): ValidationResult {
    return when {
        email.isBlank()         -> ValidationResult(false, "Email cannot be empty")
        !email.contains("@")    -> ValidationResult(false, "Email must have @")
        !email.contains(".")    -> ValidationResult(false, "Email must have domain")
        email.count { it == '@' } > 1 -> ValidationResult(false, "Invalid email format")
        else                    -> ValidationResult(true, "Valid ✅")
    }
}

fun validatePhone(phone: String): ValidationResult {
    val cleanPhone = phone.replace(" ", "").replace("-", "")
    return when {
        cleanPhone.isBlank()            -> ValidationResult(false, "Phone cannot be empty")
        !cleanPhone.all { it.isDigit() } -> ValidationResult(false, "Phone must be numbers only")
        cleanPhone.length != 10         -> ValidationResult(false, "Phone must be 10 digits")
        !cleanPhone.startsWith("6") &&
        !cleanPhone.startsWith("7") &&
        !cleanPhone.startsWith("8") &&
        !cleanPhone.startsWith("9")     -> ValidationResult(false, "Invalid Indian phone number")
        else                            -> ValidationResult(true, "Valid ✅")
    }
}

fun validateCgpa(cgpaInput: String): ValidationResult {
    val cgpa = cgpaInput.toDoubleOrNull()
    return when {
        cgpa == null        -> ValidationResult(false, "CGPA must be a number")
        cgpa < 0.0          -> ValidationResult(false, "CGPA cannot be negative")
        cgpa > 10.0         -> ValidationResult(false, "CGPA cannot exceed 10")
        else -> {
            val category = when {
                cgpa >= 9.0 -> "Outstanding 🌟"
                cgpa >= 8.0 -> "Excellent ⭐"
                cgpa >= 7.0 -> "Good 👍"
                cgpa >= 6.0 -> "Average"
                else        -> "Below Average"
            }
            ValidationResult(true, "Valid ✅ - $category")
        }
    }
}

fun validateCity(city: String): ValidationResult {
    return when {
        city.isBlank()      -> ValidationResult(false, "City cannot be empty")
        city.length < 2     -> ValidationResult(false, "City name too short")
        city.any { it.isDigit() } -> ValidationResult(false, "City cannot have numbers")
        else                -> ValidationResult(true, "Valid ✅")
    }
}

// ── Helper Functions ──

fun formatResult(result: ValidationResult): String {
    return if (result.isValid) result.message
    else "❌ ${result.message}"
}

fun getOverallStatus(passed: Int): String {
    return when(passed) {
        6    -> "PERFECT - All inputs valid! 🎉"
        in 4..5 -> "GOOD - Fix remaining errors 👍"
        in 2..3 -> "FAIR - Several errors found ⚠️"
        else -> "POOR - Most inputs invalid ❌"
    }
}