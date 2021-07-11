import { combineReducers } from "redux";

import { reducer as doctor } from "./doctor";
import { reducer as appointments } from "./appointments";

export const reducer = combineReducers({
    doctor,
    appointments
})
