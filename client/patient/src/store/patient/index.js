import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    id: 0
};

const patient = createSlice({
    name: "user",
    initialState,
    reducers: {
        fillUser(state, action) {
            state.id = action.payload.id;
        }
    }
})

export const { actions, reducer } = patient;
