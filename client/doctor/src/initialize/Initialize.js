import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { useSelector } from "react-redux";

import { getInfo } from "../api/getInfo";
import { signOut } from "../api/signout";
import { selectDoctorId } from "../store/doctor/selectors";

export const Initialize = () => {
    const [isGuest, setGuest] = useState(false);
    const doctorId = useSelector(selectDoctorId);
    const history = useHistory();

    useEffect(() => {
        if (doctorId) {
            history.replace("/doctor/appointments")
        }
    }, [history, doctorId])

    useEffect(() => {
        (async () => {
            try {
                await getInfo()
                history.replace("/doctor/appointments")
            }
            catch (e) {
                setGuest(true);
            }
        })();
    }, [history]);

    return (
        <>
            <div>Загрузка...</div>
            {isGuest ? <Link to={"/doctor/sign-in"}>Вход</Link> : null}
            {doctorId ? <a href={"/doctor/sign-in"} onClick={signOut}>Выход</a> : null}
        </>
    )
}
