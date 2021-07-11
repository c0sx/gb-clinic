import { interceptResponse } from "./responseInterceptor";

export const getAppointments = async () => {
    const response = await fetch("/api/doctor/appointments");

    if (interceptResponse(response)) {
        return response.json()
    }

    return Promise.reject();
}
