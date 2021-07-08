package app.auth

fun tryAuthenticate(username: String, password: String): UserSession? {
    if (username === "patient" && password === "123") {
        return UserSession("1234567890")
    }

    return null
}
