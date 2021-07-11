import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest } from "redux-saga/effects";

import { getInfo } from "../api/getInfo";

import { actions } from "../store/doctor"

export const getDoctorInfoAsync = createAction("getUserAsync");

function* getUserWorker() {
    const user = yield call(getInfo);
    yield put(actions.fillUser(user));
}

export function* getUserWatcher() {
    yield takeLatest(getDoctorInfoAsync.type, getUserWorker);
}
