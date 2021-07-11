import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest} from "redux-saga/effects";

import { signIn } from "../api/signIn";

import { actions } from "../store/doctor";

export const signInDoctorAsync = createAction("signInDoctor");

function* signInWorker(action) {
    const { username, password } = action.payload;

    const response = yield call(signIn, {
        username,
        password
    })

    if (!response.ok) {
        return;
    }

    yield put(actions.fillUser({ id: response.id }))
    document.location.href = "/"
}

export function* signInWatcher() {
    yield takeLatest(signInDoctorAsync.type, signInWorker);
}
