import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest } from "redux-saga/effects";

import { getInfo } from "../api/getInfo";

import { actions } from "../store/patient";

export const getPatientInfoAsync = createAction("getPatientInfoAsync");

function* getPatientWorker() {
    const patient = yield call(getInfo);
    yield put(actions.fillUser(patient));
}

export function* getPatientWatcher() {
    yield takeLatest(getPatientInfoAsync.type, getPatientWorker)
}
