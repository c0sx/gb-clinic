import { interceptResponse } from "./responseInterceptor";

export const getDoctors = async () => {
    const response = await fetch("/api/patient/doctors");

    if (interceptResponse(response)) {
        return response.json()
    }

    return Promise.reject()
}
