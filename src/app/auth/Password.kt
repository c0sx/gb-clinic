package app.auth

import at.favre.lib.crypto.bcrypt.BCrypt

class Password(public val hash: String) {
    public fun compare(password: String): Boolean {
        return BCrypt.verifyer().verify(password.toCharArray(), hash.toCharArray()).verified
    }

    companion object {
        public fun hash(password: String): Password {
            val encoded = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            return Password(encoded)
        }
    }
}