import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    doctors: []
};

const doctors = createSlice({
    name: "doctors",
    initialState,
    reducers: {
        fill(state, action) {
            state.doctors = action.payload;
        }
    }
})

export const { actions, reducer } = doctors;
