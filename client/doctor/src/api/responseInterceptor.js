export const interceptResponse = response => {
    return intercept401(response);
}

export const intercept401 = response => {
    if (response.status === 401) {
        document.location.href = "/sign-in"
        return false;
    }

    return true;
}


