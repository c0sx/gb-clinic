export const interceptResponse = response => {
    return intercept401(response);
}

export const intercept401 = response => {
    if (response.status === 401) {
        document.location.href = "/doctor/sign-in"
        return false;
    }

    return true;
}


