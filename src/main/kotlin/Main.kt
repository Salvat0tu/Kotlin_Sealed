fun main(args: Array<String>) {
    val user: User = User.Facebook("user1", "Pippo@topolina.com", "Password123")
    val user2: User = User.Google("user2", "Gianluigi@bombatomica")
    val user3: User = User.Email("user3", "Passwordsicura1")
    val users = listOf(user,user2, user3)
    for (userNum in users){
    when (userNum) {
        is User.Email -> print("Email details are $user \n \n")
        is User.Facebook -> print("Facebook details are $user \n \n")
        is User.Google -> print("Google details are $user \n \n")
    }
    }

}

sealed class User(open val id: String) {
    data class Email(override val id: String, val password: String) : User(id)
    data class Facebook(override val id: String, val email: String, val password: String) : User(id)
    data class Google(override val id: String, val email: String) : User(id)
}