import { getUnixTime } from "date-fns";

export const registerAppointment = async ({ doctorId, date }) => {
    await fetch("/api/patient/appointments", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            doctorId,
            date: getUnixTime(date) * 1000
        })
    })
}
