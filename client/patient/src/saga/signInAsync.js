import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest} from "redux-saga/effects";

import { signIn } from "../api/signIn";

import { actions } from "../store/patient";

export const signInAsync = createAction("signIn");

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
    document.location.href = "/patient"
}

export function* signInWatcher() {
    yield takeLatest(signInAsync.type, signInWorker);
}
