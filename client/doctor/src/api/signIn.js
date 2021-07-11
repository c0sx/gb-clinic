export const signIn = async ({ username, password }) => {
    return fetch("/api/doctor/sign-in", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password
        })
    })
}
