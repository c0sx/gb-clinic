import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { format, parse } from "date-fns";

import { signOut } from "../api/signOut";

import { getPatientInfoAsync } from "../saga/getPatientInfoAsync";
import { getAppointmentsAsync } from "../saga/getAppointmentsAsync";
import { getDoctorsAsync } from "../saga/getDoctorsAsync";
import { registerAppointmentAsync } from "../saga/registerAppointmentAsync";

import { selectDoctors } from "../store/doctors/selectors";
import { selectPatientId } from "../store/patient/selectors";
import { selectAppointments } from "../store/appointments/selectors";

export const Appointments = () => {
    const [doctorId, setDoctorId] = useState("");
    const [appointmentAt, setAppointmentAt] = useState("");

    const dispatch = useDispatch();
    const appointments = useSelector(selectAppointments);
    const doctors = useSelector(selectDoctors);
    const patientId = useSelector(selectPatientId);

    useEffect(() => {
        dispatch(getPatientInfoAsync())
        dispatch(getAppointmentsAsync());
        dispatch(getDoctorsAsync())
    }, [dispatch])

    const onSubmitHandler = e => {
        e.preventDefault();
        e.stopPropagation();

        const date = parse(appointmentAt, "HH:mm", new Date());
        dispatch(registerAppointmentAsync({
            doctorId,
            date,
        }))
    }

    return (
        <div>
            {patientId ? <a href={"/patient/sign-in"} onClick={signOut}>Выход</a> : null}
            <div>
                <label>Добавить</label>
                <form onSubmit={onSubmitHandler}>
                    <select required={true} onChange={e => setDoctorId(e.target.value)}>
                        <option value={""}>Выберите</option>
                        {doctors.map(one => (
                            <option key={one.id} value={one.id}>{one.surname} {one.name}</option>
                        ))}
                    </select>
                    <select value={appointmentAt} required={true} onChange={e => setAppointmentAt(e.target.value)}>
                        <option value={""}>Выберите</option>
                        <option value={"10:30"}>10:30</option>
                        <option value={"10:50"}>10:50</option>
                        <option value={"13:30"}>13:30</option>
                    </select>
                    <input type={"submit"} value={"Записаться"} />
                </form>
            </div>
            {appointments.length > 0 ?
                (
                    <ul>
                        {appointments.map(one => (
                            <li key={one.id}>
                                <div>
                                    {one.surname}
                                    {one.name}
                                    {format(one.date, "dd.MM.yyyy HH:mm")}
                                </div>
                            </li>
                        ))}
                    </ul>
                )
                :
                <p>Нет записей</p>
            }
        </div>
    )
}
