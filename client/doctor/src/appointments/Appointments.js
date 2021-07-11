import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

import { getAppointmentsAsync } from "../saga/getAppointmentsAsync";
import { selectAppointments } from "../store/appointments/selectors";
import {selectDoctorId} from "../store/doctor/selectors";
import {getDoctorInfoAsync} from "../saga/getDoctorInfoAsync";
import {signOut} from "../api/signout";


export const Appointments = () => {
    const dispatch = useDispatch();
    const appointments = useSelector(selectAppointments);
    const doctorId = useSelector(selectDoctorId);

    useEffect(() => {
        dispatch(getDoctorInfoAsync())
        dispatch(getAppointmentsAsync());
    }, [dispatch])

    return (
        <div>
            {doctorId ? <a href={"/sign-in"} onClick={signOut}>Выход</a> : null}
            {appointments.length > 0 ?
                (
                    <ul>
                        {appointments.map(one => (
                            <li>
                                <div>
                                    {one.patient.name}
                                    {one.patient.date}
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
