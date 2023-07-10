fun main(args: Array<String>) {
    val user: User = Facebook("user1", "Pippo@topolina.com", "Password123")
    when (user) {
        is Email -> print("Email details are $user")
        is Facebook -> print("Facebook details are $user")
        is Google -> print("Google details are $user")
    }

}

sealed class User(open val id: String)
data class Email(override val id: String, val password: String) : User(id)
data class Facebook(override val id: String, val email: String, val password: String) : User(id)
data class Google(override val id: String, val email: String) : User(id)
