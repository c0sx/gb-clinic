import { createSelector } from "@reduxjs/toolkit";

const getAppointments = state => state.appointments;

export const selectAppointments = createSelector(getAppointments, appointments => appointments.appointments)
