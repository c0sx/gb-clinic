import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest } from "redux-saga/effects";

import { getAppointments } from "../api/getAppointments";

import { actions } from "../store/appointments";

export const getAppointmentsAsync = createAction("getAppointmentsAsync");

function* getAppointmentsWorker() {
    const appointments = yield call(getAppointments)
    yield put(actions.fill(appointments))
}

export function* getAppointmentsWatcher() {
    yield takeLatest(getAppointmentsAsync.type, getAppointmentsWorker)
}
