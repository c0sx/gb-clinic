import { createSelector } from "@reduxjs/toolkit";

const getPatient = state => state.patient;

export const selectPatientId = createSelector(getPatient, patient => patient.id);
