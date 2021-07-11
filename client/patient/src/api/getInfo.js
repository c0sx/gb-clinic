import { interceptResponse} from "./responseInterceptor";

export const getInfo = async () => {
    const response = await fetch("/api/patient/info");

    if (interceptResponse(response)) {
        return response.json()
    }

    return Promise.reject();
}
