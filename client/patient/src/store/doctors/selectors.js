import { createSelector } from "@reduxjs/toolkit";

const getDoctor = state => state.doctors;

export const selectDoctors = createSelector(getDoctor, doctors => doctors.doctors);
