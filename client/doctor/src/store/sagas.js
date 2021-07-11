import { all, call } from "redux-saga/effects";

import { getUserWatcher } from "../saga/getDoctorInfoAsync";
import { signInWatcher } from "../saga/signInDoctorAsync";
import { getAppointmentsWatcher } from "../saga/getAppointmentsAsync";

export function* sagas() {
    yield all([
        call(getUserWatcher),
        call(signInWatcher),
        call(getAppointmentsWatcher)
    ])
}
