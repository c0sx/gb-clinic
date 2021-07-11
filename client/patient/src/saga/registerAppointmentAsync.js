import { createAction } from "@reduxjs/toolkit";
import { call, put, takeLatest } from "redux-saga/effects";

import { registerAppointment } from "../api/registerAppointment";

import { getAppointmentsAsync } from "./getAppointmentsAsync";

export const registerAppointmentAsync = createAction("registerAppointmentAsync");

function* registerAppointmentWorker(action) {
    const { doctorId, date } = action.payload;

    yield call(registerAppointment, {
        doctorId,
        date,
    })

    yield put(getAppointmentsAsync())
}

export function* registerAppointmentWatcher() {
    yield takeLatest(registerAppointmentAsync.type, registerAppointmentWorker);
}
