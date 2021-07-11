import { getUnixTime } from "date-fns";

export const signUp = async ({ username, password, user }) => {
    const { surname, name, dateOfBirth } = user
    return fetch("/api/patient/sign-up", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password,
            surname,
            name,
            dateOfBirth: getUnixTime(dateOfBirth) * 1000,
        })
    })
}
