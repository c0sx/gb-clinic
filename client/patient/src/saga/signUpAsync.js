import { createAction } from "@reduxjs/toolkit";
import { call, takeLatest } from "redux-saga/effects";

import { signUp } from "../api/signUp";
import {parse} from "date-fns";

export const signUpAsync = createAction("signUp");

function* signUpWorker(action) {
    const {
        username,
        password,
        user: {
            surname,
            name,
            dateOfBirth
        }
    } = action.payload;

    console.log(dateOfBirth, parse(dateOfBirth, "yyyy-MM-dd", new Date()))
    const response = yield call(signUp, {
        username,
        password,
        user: {
            surname,
            name,
            dateOfBirth: parse(dateOfBirth, "yyyy-MM-dd", new Date())
        }
    })

    if (!response.ok) {
        return;
    }

    document.location.href = "/patient"
}

export function* signUpWatcher() {
    yield takeLatest(signUpAsync.type, signUpWorker)
}
