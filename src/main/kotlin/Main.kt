fun main(args: Array<String>) {
    val user: User = Facebook("user1", "Pippo@topolina.com", "Password123")
    val user2: User = Google("user2", "Gianluigi@bombatomica")
    val user3: User = Email("user3", "Passwordsicura1")
    checkUser(user3)

}

fun checkUser(user: User) {
    when (user) {
        is Email -> print("Email details are $user \n \n")
        is Facebook -> print("Facebook details are $user \n \n")
        is Google -> print("Google details are $user \n \n")
    }
}

sealed class User(open val id: String)
    data class Email(override val id: String, val password: String) : User(id)
    data class Facebook(override val id: String, val email: String, val password: String) : User(id)
    data class Google(override val id: String, val email: String) : User(id)
