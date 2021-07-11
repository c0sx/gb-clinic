export const signIn = async ({ username, password }) => {
    return fetch("/api/patient/sign-in", {
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
