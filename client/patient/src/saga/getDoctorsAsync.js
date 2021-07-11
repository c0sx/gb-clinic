import { createAction } from "@reduxjs/toolkit";
import { call, takeLatest, put } from "redux-saga/effects";

import { getDoctors } from "../api/getDoctors";

import { actions } from "../store/doctors";

export const getDoctorsAsync = createAction("getDoctorsAsync");

function* getDoctorsWorker() {
    const doctors = yield call(getDoctors);
    yield put(actions.fill(doctors));
}

export function* getDoctorsWatcher() {
    yield takeLatest(getDoctorsAsync.type, getDoctorsWorker)
}
