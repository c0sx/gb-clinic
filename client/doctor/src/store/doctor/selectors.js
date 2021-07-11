import { createSelector } from "@reduxjs/toolkit";

const getDoctor = state => state.doctor;

export const selectDoctorId = createSelector(getDoctor, doctor => doctor.id);
