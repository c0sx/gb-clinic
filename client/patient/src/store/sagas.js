import { all, call } from "redux-saga/effects";

import { signInWatcher } from "../saga/signInAsync";
import { signUpWatcher } from "../saga/signUpAsync";
import { getPatientWatcher } from "../saga/getPatientInfoAsync";
import { getDoctorsWatcher } from "../saga/getDoctorsAsync";
import { getAppointmentsWatcher } from "../saga/getAppointmentsAsync";
import { registerAppointmentWatcher } from "../saga/registerAppointmentAsync";

export function* sagas() {
    yield all([
        call(signInWatcher),
        call(signUpWatcher),
        call(getPatientWatcher),
        call(getDoctorsWatcher),
        call(getAppointmentsWatcher),
        call(registerAppointmentWatcher)
    ])
}
