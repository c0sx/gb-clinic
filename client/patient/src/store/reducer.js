import { combineReducers } from "redux";

import { reducer as doctors } from "./doctors";
import { reducer as appointments } from "./appointments";
import { reducer as patient } from "./patient";

export const reducer = combineReducers({
    patient,
    doctors,
    appointments
})
