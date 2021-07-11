import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    appointments: []
}

const appointments = createSlice({
    name: "appointments",
    initialState,
    reducers: {
        fill: (state, action) => {
            state.appointments = action.payload;
        }
    }
})

export const { actions, reducer } = appointments;
